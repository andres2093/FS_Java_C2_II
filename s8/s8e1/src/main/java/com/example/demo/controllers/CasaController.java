package com.example.demo.controllers;

import com.example.demo.models.Casa;
import com.example.demo.services.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/casa")
public class CasaController {

    private final CasaService service;

    @Autowired
    public CasaController(CasaService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void guardarCasa(@RequestBody Casa casa){
        service.guardar(casa);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Casa getCasa(@PathVariable Long id){
        return service.buscarPorId(id);
    }
}
