package com.example.BP.retos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuickSortAlgorithm {

    private QuickSortAlgorithm() {
    }

    public static List<Number> sort(List<Number> listaOriginal) {

        if (listaOriginal.size() < 2) {
            return listaOriginal;
        }

        double pivote = calcularPivote(listaOriginal);

        List<Number> elementosMenoresOrdenados = sort(filtrar(listaOriginal, n -> n.doubleValue() < pivote));
        List<Number> elementosMayoresOrdenados = sort(filtrar(listaOriginal, n -> n.doubleValue() >= pivote));

        List<Number> listaOrdenada = new ArrayList<>(elementosMenoresOrdenados);
        listaOrdenada.addAll(elementosMayoresOrdenados);

        return listaOrdenada;
    }

    private static Double calcularPivote(List<Number> listaOriginal) {
        final double primerElemento = listaOriginal.get(listaOriginal.size() - 1).doubleValue();
        final double ultimoElemento = listaOriginal.get(0).doubleValue();

        return (primerElemento + ultimoElemento) / 2;
    }

    private static List<Number> filtrar(List<Number> lista, Predicate<Number> predicate) {
        return lista.stream().filter(predicate).collect(Collectors.toList());
    }
}