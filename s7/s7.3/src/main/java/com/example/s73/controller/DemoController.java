package com.example.s73.controller;

import com.example.s73.entity.Empleado;
import com.example.s73.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/empleados")
public class DemoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    private Flux<Empleado> getAllEmpleados(){
        return empleadoRepository.findAllEmpleados();
    }

    @GetMapping("/{id}")
    private Mono<Empleado> getEmpleadoById(@PathVariable String id) {
        return empleadoRepository.findEmpleadoById(id);
    }

    @PutMapping
    private Mono<Empleado> updateEmpleado(@RequestBody Empleado empleado) {
        return empleadoRepository.updateEmpleado(empleado);
    }
}
