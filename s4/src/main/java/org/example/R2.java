package org.example;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class R2 {

    private static final Random rnd = new Random();

    public static double obtenerGananciasFranquicia(int id){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return rnd.nextInt(40000) + 10000;
    }

    public static void main(String[] args) {
        List<Integer> ids = IntStream.rangeClosed(1, 1000)
                .boxed()
                .toList();

        List<CompletableFuture<Double>> futuros = ids.stream()
                .map(id -> CompletableFuture.supplyAsync(() -> obtenerGananciasFranquicia(id)))
                .toList();

        OptionalDouble maximo = futuros.stream()
                .mapToDouble(CompletableFuture::join)
                .max();

        if (maximo.isPresent()) {
            System.out.printf("La venta maxima: $%5.2f%n", maximo.getAsDouble());
        } else {
            System.out.print("Error");
        }
    }
}
