package com.example.proyectoTR100124.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.proyectoTR100124.model.Trip;
import com.example.proyectoTR100124.service.ITripService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private ITripService tripService;

    @GetMapping("/")
    public String mostrarHome(Model model) {
        List<Trip> lista = tripService.buscarTodos();
        model.addAttribute("trips", lista);
        return "home";
    }

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Trip> lista = tripService.buscarTodos();
        model.addAttribute("trips", lista);
        return "tabla";
    }

    /*@GetMapping("/trips/view/{id}")
    public String verDetalle(@PathVariable("id") int idTrip, Model model) {
        Trip trip = tripService.buscarPorId(idTrip);
        model.addAttribute("trip", trip);
        return "trips/detalle";
    }*/

    /*@GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Trip> lista = getTrips();
        model.addAttribute("trips", lista);
        return "tabla";
    }

    private List<Trip> getTrips() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Trip> lista = new LinkedList<>();

        try {
            Trip trip1 = new Trip();
            trip1.setId(1);
            trip1.setNombre("Rapel en Volcatenando");
            trip1.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
            trip1.setFecha(sdf.parse("10-05-2022"));
            trip1.setCosto(5.0);
            trip1.setDestacado(1);
            trip1.setCalificacion(6);
            trip1.setImagen("trip01.png");

            Trip trip2 = new Trip();
            trip2.setId(2);
            trip2.setNombre("Deslizadoro en El picnic");
            trip2.setDescripcion("Deslizarte en un divertido tobogan sobre la colina");
            trip2.setFecha(sdf.parse("10-05-2022"));
            trip2.setCosto(5.0);
            trip2.setDestacado(1);
            trip2.setCalificacion(8);
            trip2.setImagen("trip02.png");

            Trip trip3 = new Trip();
            trip3.setId(3);
            trip3.setNombre("Comida y Flores");
            trip3.setDescripcion("Disfrutar de un amplio jardin el cual podras comprar");
            trip3.setFecha(sdf.parse("10-05-2022"));
            trip3.setCosto(1.0);
            trip3.setDestacado(0);
            trip3.setCalificacion(5);
            trip3.setImagen("tirp03.png");

            Trip trip4 = new Trip();
            trip4.setId(4);
            trip4.setNombre("Caminatas");
            trip4.setDescripcion("Disfruta hacer senderismo por las montañas chalatecas");
            trip4.setFecha(sdf.parse("01-02-2022"));
            trip4.setCosto(10.0);
            trip4.setDestacado(1);
            trip4.setCalificacion(8);
            trip4.setImagen("no-image.png");

            Trip trip5 = new Trip();
            trip5.setId(5);
            trip5.setNombre("Lago de Coatepeque");
            trip5.setDescripcion("Paseo y comida con vista al lago");
            trip5.setFecha(sdf.parse("15-06-2022"));
            trip5.setCosto(12.0);
            trip5.setDestacado(0);
            trip5.setCalificacion(5);
            trip5.setImagen("no-image.png");

            Trip trip6 = new Trip();
            trip6.setId(6);
            trip6.setNombre("Ruta de las Flores");
            trip6.setDescripcion("Recorrido por pueblos y cafeterias");
            trip6.setFecha(sdf.parse("20-07-2022"));
            trip6.setCosto(8.0);
            trip6.setDestacado(1);
            trip6.setCalificacion(7);
            trip6.setImagen("no-image.png");

            Trip trip7 = new Trip();
            trip7.setId(7);
            trip7.setNombre("Playa El Tunco");
            trip7.setDescripcion("Dia de playa y atardecer");
            trip7.setFecha(sdf.parse("05-08-2022"));
            trip7.setCosto(6.0);
            trip7.setDestacado(0);
            trip7.setCalificacion(3);
            trip7.setImagen("no-image.png");

            lista.add(trip1);
            lista.add(trip2);
            lista.add(trip3);
            lista.add(trip4);
            lista.add(trip5);
            lista.add(trip6);
            lista.add(trip7);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }*/
}