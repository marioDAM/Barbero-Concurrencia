import java.util.Random;

public class Cliente extends Thread {
    private Barberia barberia;

    private String nombre;
    private Random generator = new Random();

    public Cliente(String nombre, Barberia barberia) {
        this.barberia = barberia;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void run() {
        try {
            sleep(generator.nextInt(10000));
            barberia.entrarBarberia(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
