package com.example.proyectoTR100124.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoTR100124.model.Trip;

public interface ITripRepository extends JpaRepository<Trip, Integer> {
}