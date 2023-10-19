package org.bedu.jse2.demo.reactive.ejemplo1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Ejemplo1Test {

    @Test
    @DisplayName("Suma los elementos y regresa Single")
    void sumarSingle() {
        Ejemplo1.sumarSingle()
                .subscribe(s -> assertThat(s).isEqualTo(21));
    }

    @Test
    @DisplayName("Suma los elementos y regresa valor (bloqueante)")
    void sumar() {
        assertThat(Ejemplo1.sumar()).isEqualTo(21);
    }

    @Test
    @DisplayName("Reto 1")
    void cubosFiltrados(){
        Ejemplo1.reto()
                .subscribe(s -> assertThat(s).isEqualTo(405));
    }
}