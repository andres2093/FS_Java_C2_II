// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MiHilo hilo1 = new MiHilo("Uno");
//        hilo1.setDaemon(true);
        hilo1.start();

        MiHilo hilo2 = new MiHilo("Dos");
        hilo2.setDaemon(true);
        hilo2.start();

        MiHilo.pausar();
        hilo1.setParametro("Terminar");
        System.out.println("----------------------------------");
        System.out.println("Fin del hilo main");
        System.out.println("----------------------------------");
    }
}