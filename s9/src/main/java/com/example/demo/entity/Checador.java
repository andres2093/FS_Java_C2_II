package com.example.demo.entity;

import java.time.LocalDateTime;

public class Checador {

    private Empleado empleado;
    private boolean esEntrada;
    private LocalDateTime localDateTime;

    public Checador(Empleado empleado, boolean esEntrada) {
        this.empleado = empleado;
        this.esEntrada = esEntrada;
        localDateTime = LocalDateTime.now();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public boolean isEsEntrada() {
        return esEntrada;
    }

    public void setEsEntrada(boolean esEntrada) {
        this.esEntrada = esEntrada;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
