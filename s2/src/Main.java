// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        -------------------E1-------------------------
//        MiHilo hilo1 = new MiHilo("Uno");
////        hilo1.setDaemon(true);
//        hilo1.start();
//
//        MiHilo hilo2 = new MiHilo("Dos");
//        hilo2.setDaemon(true);
//        hilo2.start();
//
//        MiHilo.pausar();
//        hilo1.setParametro("Terminar");
//        System.out.println("----------------------------------");
//        System.out.println("Fin del hilo main");
//        System.out.println("----------------------------------");

//        ---------------------R1------------------------
//        Hilo1 h1 = new Hilo1();
//        Hilo2 h2 = new Hilo2();
//        h2.setDaemon(true);
//
//        h1.start();
//        h2.start();


//        ---------------------E2------------------------
//        MiRunnable runnable1 = new MiRunnable("Uno");
//        MiRunnable runnable2 = new MiRunnable("Dos");
//
//        Thread t1 = new Thread(runnable1);
//        t1.start();
//
//        Thread t2 = new Thread(runnable2);
//        t2.setDaemon(true);
//        t2.start();
//
//        MiRunnable.pausar();
//        runnable1.setParametro("Terminar");
//        System.out.println("----------------------------------");
//        System.out.println("Fin del hilo main");
//        System.out.println("----------------------------------");


//        ---------------------R2------------------------
        Thread t1 = new Thread(new Hilo1());
        Thread t2 = new Thread(new Hilo2());
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}