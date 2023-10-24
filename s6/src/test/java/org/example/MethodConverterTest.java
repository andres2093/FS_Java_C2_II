package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodConverterTest {

    @Test
    @DisplayName("Prueba con Integers")
    void prueba(){
        Integer input = 23423;
        String expected = "23423";

        String output = MethodConverter.convertToString(input);

        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Prueba con Dobles")
    void doble(){
        Double input = 23423.0;
        String expected = "23423.0";

        String output = MethodConverter.convertToString(input);

        assertEquals(expected, output);
    }
}