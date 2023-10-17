package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E2 {

    public static void main(String[] args) {
        System.out.println("------E2-------");
        List<Integer> ids = IntStream.range(1, 11)
                .boxed()
                .toList();

        List<CompletableFuture<Double>> futuros = ids.stream()
                .map(id -> CompletableFuture.supplyAsync(() -> leer(id)))
//                .collect(Collectors.toList());
                .toList();

        obtenerPromedio(futuros);
    }

    static void obtenerPromedio(List<CompletableFuture<Double>> futuros){
        LocalTime inicio = LocalTime.now();
        double promedio = futuros.stream()
                .mapToDouble(id -> id.join())
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
