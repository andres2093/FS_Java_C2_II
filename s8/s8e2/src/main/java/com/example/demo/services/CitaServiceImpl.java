package com.example.demo.services;

import com.example.demo.models.Cita;
import com.example.demo.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository repository;

    @Autowired
    public CitaServiceImpl(CitaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void guardar(Cita cita) {

        if (repository.findAllByContenido(cita.getContenido()).size() > 0) {
            throw new RuntimeException("La cita ya fue registrada");
        }

        repository.save(cita);
    }

    @Override
    public Cita buscarPorId(Long id) {
        return repository.findById(id).get();
    }
}