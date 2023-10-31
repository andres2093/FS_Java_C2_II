package com.example.demo.services;

import com.example.demo.models.Cita;

public interface CitaService {

    void guardar(Cita cita);

    Cita buscarPorId(Long id);
}