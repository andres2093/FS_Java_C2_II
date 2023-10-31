package com.example.demo.services;

import com.example.demo.models.Casa;

public interface CasaService {

    void guardar(Casa casa);
    Casa buscarPorId(Long id);
}
