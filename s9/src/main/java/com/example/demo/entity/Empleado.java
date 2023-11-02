package com.example.demo.entity;

public class Empleado {

    private final String id;
    private final String nombre;

    public Empleado(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
