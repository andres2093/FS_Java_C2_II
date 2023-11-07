package org.example.hilos;

public class Hilos extends Thread{

    private String nombre;
    private int retardo;

    public Hilos(String nombre, int retardo){
        this.nombre = nombre;
        this.retardo = retardo;
    }

    @Override
    public void run() {
        try {
            sleep(retardo);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(nombre + " " + retardo);
    }
}
