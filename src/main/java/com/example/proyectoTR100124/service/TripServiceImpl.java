package com.example.proyectoTR100124.service;

import org.springframework.stereotype.Service;

import com.example.proyectoTR100124.model.Trip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class TripServiceImpl implements ITripService {

    List<Trip> lista = null;

    public TripServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<>();

        try {
            Trip trip1 = new Trip();
            trip1.setId(1);
            trip1.setNombre("Rapel en Volcatenango");
            trip1.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
            trip1.setFecha(sdf.parse("10-05-2022"));
            trip1.setCosto(5.0);
            trip1.setDestacado(1);
            trip1.setCalificacion(6);
            trip1.setImagen("trip01.png");

            Trip trip2 = new Trip();
            trip2.setId(2);
            trip2.setNombre("Deslizador en El Picnic");
            trip2.setDescripcion("Deslizarte en un divertido tobogán sobre la colina");
            trip2.setFecha(sdf.parse("10-05-2022"));
            trip2.setCosto(5.0);
            trip2.setDestacado(1);
            trip2.setCalificacion(8);
            trip2.setImagen("trip02.png");

            Trip trip3 = new Trip();
            trip3.setId(3);
            trip3.setNombre("Comida y Flores");
            trip3.setDescripcion("Disfrutar de un amplio jardín donde podrás comprar flores");
            trip3.setFecha(sdf.parse("10-05-2022"));
            trip3.setCosto(1.0);
            trip3.setDestacado(0);
            trip3.setCalificacion(5);
            trip3.setImagen("trip03.png");

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
            trip6.setDescripcion("Recorrido por pueblos y cafeterías");
            trip6.setFecha(sdf.parse("20-07-2022"));
            trip6.setCosto(8.0);
            trip6.setDestacado(1);
            trip6.setCalificacion(7);
            trip6.setImagen("no-image.png");

            Trip trip7 = new Trip();
            trip7.setId(7);
            trip7.setNombre("Playa El Tunco");
            trip7.setDescripcion("Día de playa y atardecer");
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
    }

    @Override
    public List<Trip> buscarTodos() {
        return lista;
    }

    @Override
    public Trip buscarPorId(Integer idTrip) {
        for (Trip trip : lista) {
            if (Objects.equals(trip.getId(), idTrip)) {
                return trip;
            }
        }
        return null;
    }

    @Override
    public void guardar(Trip trip) {
        lista.add(trip);
    }

    @Override
    public void eliminar(Integer idTrip) {
        lista.removeIf(trip -> trip.getId().equals(idTrip));
    }
}