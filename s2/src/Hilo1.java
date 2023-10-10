import java.util.concurrent.TimeUnit;

// R1
//public class Hilo1 extends Thread {

// R2
public class Hilo1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Hilo1: " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
