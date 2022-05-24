import java.util.ArrayList;
import java.util.List;

public class Barberia {

    private boolean sillaBarberoOcupada = false;

    private int sillasDisponibles = 5;


    private List<Cliente> clientes = new ArrayList<>();

    public synchronized boolean estaVacia() throws InterruptedException {
        boolean vacia;
        while (sillasDisponibles == 5) {
            System.out.println("Como la barberia esta vacia me duermo");
            wait();
        }
        vacia = false;
        return vacia;
    }


    public synchronized void entrarBarberia(Cliente cliente) throws InterruptedException {
        if (sillasDisponibles == 0) {
            System.out.println("El cliente " + cliente.getNombre() + " se va de la peluqueria sin ser cortado");
        } else {
            System.out.println("El cliente " + cliente.getNombre() + " entra a la peluquería");
            System.out.println("El cliente " + cliente.getNombre() + " se sienta en silla de espera");
            sillasDisponibles--;
            notify(); //Porque la silla del barbero solo coge a 1 y solo hay un barbero
            clientes.add(cliente);
        }
    }

    public synchronized Cliente iniciarCorte() {
        sillaBarberoOcupada = true;
        sillasDisponibles++;
        Cliente cliente = clientes.get(0);
        clientes.remove(0);
        System.out.println("El cliente " + cliente.getNombre() + " se esta cortando el pelo");
        return cliente;
    }

    public synchronized boolean finCorte() {
        sillaBarberoOcupada = false;
        return sillaBarberoOcupada;
    }

}
