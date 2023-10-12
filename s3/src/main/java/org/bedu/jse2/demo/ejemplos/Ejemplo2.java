package org.bedu.jse2.demo.ejemplos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Ejemplo2 {
    List<Integer> transformar(Iterable<Integer> conjunto, Function<Integer, Integer> funcion) {
        List<Integer> lista = new ArrayList<>();
        for (Integer valor : conjunto) {
            lista.add(funcion.apply(valor));
        }
        return lista;
    }

    Integer transformarYSumar(Iterable<Integer> conjunto, Function<Integer, Integer> funcion) {
        Integer acumulador = 0;
        for (Integer value : conjunto) {
            acumulador += funcion.apply(value);
        }
        return acumulador;
    }
}
