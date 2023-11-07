package org.example;

import org.example.hilos.Hilos;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            new Hilos("Hilo " + i, 10000).start();

            Thread hilo = new Hilos("Hilo " + i, 10000);
            hilo.setDaemon(true);
            hilo.start();
        }
    }
}