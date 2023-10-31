package com.example.demo.controllers;

import com.example.demo.models.Cita;
import com.example.demo.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cita")
public class CitaController {

    private final CitaService service;

    @Autowired
    public CitaController(CitaService repository) {
        this.service = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void guardarCita(@RequestBody Cita cita){
        service.guardar(cita);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cita buscarCita(@PathVariable Long id){
        return service.buscarPorId(id);
    }
}