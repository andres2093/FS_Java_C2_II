package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EchoClassTest {
    @Test
    @DisplayName("Eco de un String (generic explicito)")
    void echoString(){
        String input = "Hola mundo";
        String output = EchoClass.<String>echo(input);

        assertEquals(input, output);
    }

    @Test
    @DisplayName("Eco de un Integer (generic implicito, tipo inferido)")
    void echoInteger(){
        Integer input = 85549;
        Integer output = EchoClass.echo(input);

        assertEquals(input, output);
    }
}