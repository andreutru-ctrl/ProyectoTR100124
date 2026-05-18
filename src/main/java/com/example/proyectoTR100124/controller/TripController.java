package com.example.proyectoTR100124.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectoTR100124.model.Trip;
import com.example.proyectoTR100124.service.ICategoriaService;
import com.example.proyectoTR100124.service.ITripService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private ITripService servicesTrip;

    @Autowired
    private ICategoriaService serviceCategoria;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Trip> lista = servicesTrip.buscarTodos();
        model.addAttribute("trips", lista);
        return "trips/listTrips";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("categorias", serviceCategoria.buscarTodas());
        return "trips/formTrip";
    }

    @PostMapping("/save")
    public String guardar(Trip trip, BindingResult result, Model model, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }

            model.addAttribute("categorias", serviceCategoria.buscarTodas());
            return "trips/formTrip";
        }

        servicesTrip.guardar(trip);
        attributes.addFlashAttribute("msg", "Registro guardado correctamente");

        return "redirect:/trips/index";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idTrip, Model model) {
        Trip trip = servicesTrip.buscarPorId(idTrip);
        model.addAttribute("trip", trip);
        model.addAttribute("categorias", serviceCategoria.buscarTodas());
        return "trips/formTrip";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idTrip, RedirectAttributes attributes) {
        servicesTrip.eliminar(idTrip);
        attributes.addFlashAttribute("msg", "Trip eliminado correctamente");
        return "redirect:/trips/index";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idTrip, Model model) {
        Trip trip = servicesTrip.buscarPorId(idTrip);
        model.addAttribute("trip", trip);
        return "trips/detalle";
    }
}