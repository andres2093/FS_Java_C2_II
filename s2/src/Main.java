import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
//        Thread t1 = new Thread(new Hilo1());
//        Thread t2 = new Thread(new Hilo2());
//        t2.setDaemon(true);
//
//        t1.start();
//        t2.start();


//        ---------------------E3------------------------
        ExecutorService pool = Executors.newCachedThreadPool(); // creamos un pool preconfigurado

        String[] nombres = {"Uno", "Dos", "Tres"}; //los nombres para nuestros hilos
        for (String nombre : nombres) {
            pool.execute(new MiRunnablePool(nombre)); // creamos cada hilo y lo ejecutamos
        }
        System.out.println("Estado del pool antes de apagar: isShutdown()=" + pool.isShutdown() + ", isTerminated()=" + pool.isTerminated());
        pool.shutdown(); // Apagamos el pool para que no pueda recibir nuevos hilos

//pool.execute(new MiRunnablePool("Cuatro")); // si tratamos de hacer esto recibiremos una excepción
        System.out.println("Estado del pool después de apagar: isShutdown()=" + pool.isShutdown() + ", isTerminated()=" + pool.isTerminated());

        try {
            long tiempoLimiteMs = 100;
            System.out.println("Esperando que los hilos finalicen en " + tiempoLimiteMs + "ms...");

            boolean terminaron = pool.awaitTermination(tiempoLimiteMs, TimeUnit.MILLISECONDS); //Esperamos a los hilos por 100ms, retorna true si acabaron antes o hasta los 100ms o false si fueron interrumpidos
            System.out.println("¿Terminaron nuestros hilos? " +  terminaron);

            if(!terminaron){
                System.out.println("Llamando a shutdownNow()...");
                List<Runnable> pendientes = pool.shutdownNow(); //Termina los hilos que se estén ejecutando y retorna una lista de hilos pendientes a ejecutarse
                System.out.println(pendientes.size() + " hilos pendientes");
                terminaron = pool.awaitTermination(tiempoLimiteMs, TimeUnit.MILLISECONDS); //esperando otros 100ms a que terminen nuestros hilos

                if(!terminaron){
                    System.out.println("Aún hay hilos pendientes");
                }
                System.out.println("Saliendo de main");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}