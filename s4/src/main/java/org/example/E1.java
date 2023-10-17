package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E1 {

    public static void main(String[] args) {
        List<Integer> ids = IntStream.range(1, 101)
                .boxed()
                .toList();
        obtenerPromedio(ids.stream()); // procesamiento concurrente
        obtenerPromedio(ids.parallelStream()); // procesamiento paralelo
    }

    static void obtenerPromedio(Stream<Integer> ids){
        LocalTime inicio = LocalTime.now();
        double promedio = ids.mapToDouble(id -> leer(id))
                .average()
                .orElse(0);
        Duration tiempo = Duration.between(inicio, LocalTime.now());
        System.out.println((Math.round(promedio * 100.) / 100.) + " en " + tiempo.toMillis() + " ms");
    }

    static double leer(int id){
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return id * Math.random();
    }
}
