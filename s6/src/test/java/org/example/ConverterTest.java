package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    @DisplayName("Convierte enteros")
    void string() {
        Integer integer = 5242;
        String expected = "5242";

        Converter<Integer> integerConverter = new Converter<>();

        assertEquals(expected, integerConverter.convertir(integer));
    }

    @Test
    @DisplayName("Convierte un Boolean")
    void booleano() {
        Boolean aBoolean = Boolean.TRUE;
        String expected = "true";

        Converter<Boolean> integerConverter = new Converter<>();

        assertEquals(expected, integerConverter.convertir(aBoolean));
    }

    @Test
    @DisplayName("Convierte un Doble")
    void doble() {
        Double aDouble = 25.5;
        String expected = "25.5";

        Converter<Double> converter = new Converter<>();

        assertEquals(expected, converter.convertir(aDouble));
    }
}