package org.bedu.jse2.demo.reactive.ejemplo2;

import org.bedu.jse2.demo.reactive.ejemplo1.Ejemplo1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Ejemplo2Test {

    @Test
    @DisplayName("Suma los elementos y regresa Mono")
    void sumarMono() {
        Ejemplo2.sumarMono()
                .subscribe(s -> assertThat(s).isEqualTo(21));
    }

    @Test
    @DisplayName("Suma los elementos y regresa valor (bloqueante)")
    void sumar() {
        assertThat(Ejemplo2.sumar()).isEqualTo(21);
    }
}