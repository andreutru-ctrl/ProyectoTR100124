package com.example.proyectoTR100124.repository;

import com.example.proyectoTR100124.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
}