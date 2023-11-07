package com.example.demo.repository;

import com.example.demo.entity.Checador;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ChecadorRepository extends ReactiveMongoRepository<Checador, String> {
}
