package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class R1 {

    private static Random rnd = new Random();

    static double obtenerGananciasFranquicia(int id) {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return rnd.nextInt(40000) + 10000;
    }

    private static void obtenerSuma(Stream<Integer> ids) {
        LocalTime inicio = LocalTime.now();
        double suma = ids.mapToDouble(id -> obtenerGananciasFranquicia(id)).sum();
        System.out.printf("Las ganancias totales son: $%5.2f%n", suma);
        Duration tiempo = Duration.between(inicio, LocalTime.now());
        System.out.println((Math.round(suma * 100.) / 100.) + " en " + tiempo.toMillis() + "ms");
    }

    public static void main(String[] args) {
        List<Integer> ids = IntStream.range(0, 1000)
                .boxed()
                .toList();
        obtenerSuma(ids.parallelStream());  //procesamiento paralelo
    }
}
