package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LimitedConverterTest {
    @Test
    @DisplayName("Con enteros")
    void integers(){
        Integer numero1 = 3;
        Integer numero2 = 4;
        LimitedConverter<Integer> converter = new LimitedConverter<>();
        assertFalse(converter.esMayorQue(numero1, numero2));
    }
    @Test
    @DisplayName("Con dobles")
    void dobles(){
        Double numero1 = 3.4;
        Double numero2 = 4.7;
        LimitedConverter<Double> converter = new LimitedConverter<>();
        assertFalse(converter.esMayorQue(numero1, numero2));
    }
}