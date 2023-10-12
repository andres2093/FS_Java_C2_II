package org.bedu.jse2.demo.ejemplos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class Ejemplo3Test {
    @Test
    @DisplayName("Manipula y suma")
    void manipulaYSuma() {
        Ejemplo3 ejemplo3 = new Ejemplo3();
        List<Integer> conjunto = Arrays.asList(1, 4, -6, 7, 3, 5, -1);
        Integer expected = -27;
        assertThat(ejemplo3.manipular(conjunto, i -> i < 0 ? i : -i)).isEqualTo(expected);
    }

    IntStream iterator = new Random().ints(100, 1, 20);
    @Test
    @DisplayName("Sumando numeros")
    void sumandoNumeros(){
        assertThat(iterator.sum()).isEqualTo(10);
    }
    @Test
    @DisplayName("Revisar valores")
    void revisarValores(){
        System.out.println(Arrays.toString(iterator.toArray()));
    }

    List<String> lista = Arrays.asList("Antonio", "Maria", "Juan", "Pedro", "Rafael", "Salvador");

    @Test
    @DisplayName("Iterando con for")
    void iterandoConFor(){
        int i = 0;
        for (String nombre : lista) {
            if (nombre.contains("a")) {
                i++;
            }
        }
        assertThat(i).isEqualTo(4);
    }

    @Test
    @DisplayName("Iterando con stream")
    void iterandoConStream(){
        assertThat(lista.stream().filter(nombre -> nombre.contains("a")).count()).isEqualTo(4);
    }

}