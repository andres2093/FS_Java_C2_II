import java.util.concurrent.TimeUnit;

public class MiRunnable implements Runnable {

    private String parametro, nombre;

    public MiRunnable(String nombre) {
        this.nombre = nombre;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void run() {
//        while (!parametro.equals("Terminar")){
        while (!"Terminar".equals(parametro)){
            mostrarInformacion();
            pausar();
        }
        mostrarInformacion();
    }

    private void mostrarInformacion(){
        System.out.println("Hilo: " + nombre + "\t| Parametro: " + parametro);
    }

    public static void pausar(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
