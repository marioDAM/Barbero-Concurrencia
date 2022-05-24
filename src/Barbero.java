public class Barbero extends Thread {
    private Barberia barberia;

    public Barbero(Barberia barberia) {
        this.barberia = barberia;
    }

    public void run() {
        while (true) {
            try {
                while (barberia.estaVacia()) ;
                Cliente cliente = barberia.iniciarCorte();
                sleep(3000);
                if (barberia.finCorte()) ;
                System.out.println("Cliente" + cliente.getNombre() + "se ha cortado el pelo");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
