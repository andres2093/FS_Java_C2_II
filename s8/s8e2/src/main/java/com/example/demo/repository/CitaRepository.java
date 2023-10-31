package com.example.demo.repository;

import com.example.demo.models.Cita;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitaRepository extends CrudRepository<Cita, Long> {

    List<Cita> findAllByContenido(String contenido);
}
