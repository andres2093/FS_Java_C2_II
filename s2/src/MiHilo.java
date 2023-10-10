import java.util.concurrent.TimeUnit;

public class MiHilo extends Thread{

    String parametro;

    public MiHilo(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void run() {
        while (!parametro.equals("Terminar")){
            mostrarInformacion();
            pausar();
        }
        mostrarInformacion();
    }

    public void setParametro(String parametro){
        this.parametro = parametro;
    }

    private void mostrarInformacion(){
        String tipoHilo = isDaemon() ? "daemon" : "usuario";
        System.out.println(tipoHilo + "\t| Nombre: " + getName() + "\t| " + getId() + "\t| Parametro:" + parametro);
    }

    public static void pausar(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
