package com.example.proyectoTR100124.service;

import java.util.List;

import com.example.proyectoTR100124.model.Trip;

public interface ITripService {

    List<Trip> buscarTodos();

    Trip buscarPorId(Integer idTrip);

    void guardar(Trip trip);

    void eliminar(Integer idTrip);
}