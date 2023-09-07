import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<Integer>> matrizDePrueba=new ArrayList<>();
        for(int i=0; i<5; i++){
            ArrayList<Integer> filaIterada=new ArrayList<>();
            for(int j=0; j<5; j++) {
                filaIterada.add(j);
            }
            matrizDePrueba.add(filaIterada);
        }
        /* PROBANDO MATRIZ MAL Construida */
        /*
        ArrayList<Integer> filaMala=new ArrayList<>();
        filaMala.add(1);
        filaMala.add(2);
        filaMala.add(3);
        matrizDePrueba.add(filaMala);
         */

        /*
         * {0,0,0,0},{1,1,1,1},{2,2,2,2}
         */
        Matriz matriz=new Matriz();
        matriz.setMatriz(matrizDePrueba);
        System.out.println("-------------------\nMATRIZ ORIGINAL\n");
        matriz.mostrarMatriz(matriz.getMatriz());
        System.out.println("-------------------\nMATRIZ DIVIDIDA\n");
        matriz.mostrarMatriz(matriz.dividir());
        System.out.println("-------------------");
        ArrayList<ArrayList<Integer>> matrizDividida= matriz.dividir();
        int cantidadHilosMatrizDivida= matriz.cantidadDeHilosATener(matrizDividida);
        System.out.println("APP: cantidad hilos a tener: "+cantidadHilosMatrizDivida);
        Hilos hilos = new Hilos(cantidadHilosMatrizDivida,matrizDividida);
        hilos.crearHilos();
        System.out.println("-------------------");
        hilos.inicializarTodosLosHilos();
        for (Thread hilo : hilos.getHilos()) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("APP: voy a buscar la suma de hilos al objeto Hilos");
        hilos.mostrarSuma();

    }

}