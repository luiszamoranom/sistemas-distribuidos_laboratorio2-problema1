import java.util.ArrayList;
import java.time.LocalTime; 

class Hilos {
    LocalTime tiempoAhora = LocalTime.now();
    private int cantHilos;
    private ArrayList<ArrayList<Integer>> matriz;

    public Hilos(int cantHilos, ArrayList<ArrayList<Integer>> matriz) {
        this.cantHilos = cantHilos;
        this.matriz=matriz;
    }

    public void crearHilos() {
        System.out.println(tiempoAhora+" => CREANDO HILOS");
        for (int i = 1; i <= cantHilos; i++) {
            /*
             * Thread es la clase de Java que crea como tal un hilo
             * en su interior le pasamos un objeto que operará la lógica
             * que realizará cada hilo
             */
            Thread hilo= new Thread(new Hilo(i,matriz.get(i-1)));
            hilo.start();
        }
    }
}