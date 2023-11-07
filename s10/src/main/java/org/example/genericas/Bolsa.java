package org.example.genericas;

import java.util.ArrayList;

public class Bolsa<T> {
    private ArrayList<T> lista = new ArrayList<>();

    public void add(T objeto){
        lista.add(objeto);
    }

    public ArrayList<T> getProductos(){
        return lista;
    }

    public static void main(String[] args) {
        Bolsa<Bebida> bolsa1 = new Bolsa<>();
        Bolsa<Chocolate> bolsa2 = new Bolsa<>();

        bolsa1.add(new Bebida("Limon"));
        bolsa1.add(new Bebida("Fresa"));

        bolsa2.add(new Chocolate("Avellana"));
        bolsa2.add(new Chocolate("Amargo"));

        System.out.println(bolsa1.getProductos());
        System.out.println(bolsa2.getProductos());

        Bolsa bolsa = new Bolsa();
        bolsa.add(new Bebida("Limon"));
        bolsa.add(new Chocolate("Avellana"));

        System.out.println(bolsa.getProductos());
    }
}
