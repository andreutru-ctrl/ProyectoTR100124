package com.example.proyectoTR100124.service;

import java.util.List;

import com.example.proyectoTR100124.model.Categoria;

public interface ICategoriaService {

    List<Categoria> buscarTodas();

    Categoria buscarPorId(Integer idCategoria);

    void guardar(Categoria categoria);

    void eliminar(Integer idCategoria);
}