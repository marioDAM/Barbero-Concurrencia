import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        Barberia barberia = new Barberia();
        Barbero barbero = new Barbero(barberia);
        for (int i = 0; i < 20; i++) {
            Cliente cliente = new Cliente("Javier" + i, barberia);
            cliente.start();
        }
        barbero.start();
    }
}
