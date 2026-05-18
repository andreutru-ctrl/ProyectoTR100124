package com.example.proyectoTR100124.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectoTR100124.model.Categoria;
import com.example.proyectoTR100124.service.ICategoriaService;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaTripController {

    @Autowired
    private ICategoriaService serviceCategoria;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Categoria> lista = serviceCategoria.buscarTodas();
        model.addAttribute("categorias", lista);
        return "categoriasTrip/listCategoria";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoriasTrip/formCategoria";
    }

    @PostMapping("/save")
    public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "categoriasTrip/formCategoria";
        }

        serviceCategoria.guardar(categoria);
        attributes.addFlashAttribute("msg", "Registro guardado correctamente");

        return "redirect:/categorias/index";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idCategoria, Model model) {
        Categoria categoria = serviceCategoria.buscarPorId(idCategoria);
        model.addAttribute("categoria", categoria);
        return "categoriasTrip/formCategoria";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idCategoria, RedirectAttributes attributes) {
        serviceCategoria.eliminar(idCategoria);
        attributes.addFlashAttribute("msg", "Categoría eliminada correctamente");
        return "redirect:/categorias/index";
    }
}