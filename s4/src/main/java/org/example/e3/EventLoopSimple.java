package org.example.e3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class EventLoopSimple implements Runnable {
    private static double acumulador;
    private boolean enEjecucion = false;
    private Queue<Object> listaTareas = new LinkedList<>();
    private final EventHandler worker;

    public EventLoopSimple(EventHandler worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        try{
            while(enEjecucion || !listaTareas.isEmpty()){
                Object evento = listaTareas.poll();

                if(evento == null){
                    System.out.println("No hay eventos pendientes, esperando 1s...");
                    TimeUnit.SECONDS.sleep(1);
                } else if(evento instanceof Number) {
                    acumulador += ((Number) evento).doubleValue();
                    System.out.println("Acumulado: " + acumulador);
                }
                worker.procesarEvento(evento);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            enEjecucion = false;
            e.printStackTrace();
        }
    }

    public void iniciar(){
        acumulador = 0;
        this.enEjecucion = true;
        new Thread(this).start();
    }

    public void detener(){
        this.enEjecucion = false;
    }

    public void registrarEvento(Object evento){
        listaTareas.add(evento);
    }

    public boolean isEnEjecucion(){
        return enEjecucion;
    }
}
