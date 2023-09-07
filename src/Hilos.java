import java.util.ArrayList;
import java.time.LocalTime; 

class Hilos {
    LocalTime tiempoAhora = LocalTime.now();
    private int cantHilos;
    private ArrayList<ArrayList<Integer>> matriz;
    private ArrayList<Thread> hilos;
    private Suma sumaHilos;

    public Hilos(int cantHilos, ArrayList<ArrayList<Integer>> matriz) {
        this.cantHilos = cantHilos;
        this.matriz=matriz;
        hilos= new ArrayList<>();
        sumaHilos=new Suma();
    }

    public void crearHilos() {
        System.out.println("    "+tiempoAhora+" => HILOS: creando hilos");
        for (int i = 1; i <= cantHilos; i++) {
            /*
             * Thread es la clase de Java que crea como tal un hilo
             * en su interior le pasamos un objeto que operará la lógica
             * que realizará cada hilo
             */
            Thread hilo= new Thread(new Hilo(i,matriz.get(i-1),sumaHilos));
            System.out.println("    "+tiempoAhora+" => HILOS: hilo "+i+" añadido a hilos");
            hilos.add(hilo);
            
        }
    }

    public void inicializarTodosLosHilos(){
        for(Thread hilo: hilos){
            hilo.start();
        }
        System.out.println("    "+tiempoAhora+" => HILOS: todos los hilos inicializados ; sumaHilos(compartida): "+sumaHilos.getSuma());
    }

    public void mostrarSuma() {
        System.out.println("    "+tiempoAhora+" => HILOS: mostrando suma => sumaHilos: "+sumaHilos.getSuma());
    }

    public ArrayList<Thread> getHilos(){
        return hilos;
    }
}