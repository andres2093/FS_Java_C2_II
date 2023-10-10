import java.util.concurrent.TimeUnit;

// R1
//public class Hilo2 extends Thread {

// R2
public class Hilo2 implements Runnable {
    @Override
    public void run() {
        while(true){
            System.out.println("Hilo2: Sigo en ejecución...");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
