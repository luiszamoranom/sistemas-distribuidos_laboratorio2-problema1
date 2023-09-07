import java.util.ArrayList;
import java.time.LocalTime; 

class Hilo implements Runnable {
    LocalTime tiempoAhora = LocalTime.now();
    private final int threadId;
    private ArrayList<Integer> fila;
    private Suma sumaHilos;

    public Hilo(int threadId, ArrayList<Integer> fila, Suma sumaHilos) {
        this.threadId = threadId;
        this.fila=fila;
        this.sumaHilos=sumaHilos;
    }

    public void mostrarFila(){
        System.out.println(fila.toString());
    }

    public int getThreadID(){
        return threadId;
    }

    @Override
    public void run() {
        try {
            int sumaFila=sumar(fila);
            System.out.println("    "+tiempoAhora+" => HILO: hilo "+threadId+" :"+fila.toString()+" termina de sumar => suma:"+sumaFila);
            synchronized(Hilos.class){
                sumaHilos.sumar(sumaFila);
            }
            System.out.println("        "+tiempoAhora+" => HILO: hilo "+threadId+" :"+fila.toString()+" suma a sumaHilos => sumaHilos:"+sumaHilos.getSuma()+" => ahora terminará");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(tiempoAhora+" => Hilo " + threadId + " finalizado.");
    }

    public int sumar(ArrayList<Integer> fila){
        int total=0;
        for(int numeroIterado: fila){
            total+=numeroIterado;
        }
        return total;
    }
}