import java.util.ArrayList;
import java.time.LocalTime; 

class Hilo implements Runnable {
    LocalTime tiempoAhora = LocalTime.now();
    private final int threadId;
    private ArrayList<Integer> fila;

    public Hilo(int threadId, ArrayList<Integer> fila) {
        this.threadId = threadId;
        this.fila=fila;
    }

    public void mostrarFila(){
        System.out.println(fila.toString());
    }

    @Override
    public void run() {
        System.out.println(tiempoAhora+" => Hilo " + threadId + " iniciado.");
        try {
            System.out.println(tiempoAhora+" =>Fila de Hilo "+threadId+" :"+fila.toString());
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