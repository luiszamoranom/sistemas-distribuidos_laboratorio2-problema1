import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime; 
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        LocalTime tiempoAhora = LocalTime.now();
        boolean inputFilaCorrecto=false;
        int fila=-1;
        int columna=-1;
        while(inputFilaCorrecto!=true){
            System.out.println("Ingrese la cantidad de filas:");
            fila=scanner.nextInt();
            if(fila>=0 && fila<=9){
                inputFilaCorrecto=true;
            }else{
                System.out.println("APP: error, cantidad de fila debe ir de 0 a 9 incluyendolos\n");
            }
        }

        boolean inputColumnaCorrecto=false;
        while(inputColumnaCorrecto!=true){
            System.out.println("Ingrese la cantidad de columnas:");
            columna=scanner.nextInt();
            if(columna>=0 && columna<=9){
                inputColumnaCorrecto=true;
            }else{
                System.out.println("APP: error, cantidad de columna debe ir de 0 a 9 incluyendolos\n");
            }
        }

        ArrayList<ArrayList<Integer>> matrizDePrueba=new ArrayList<>();
        for(int i=0; i<fila; i++){
            ArrayList<Integer> filaIterada=new ArrayList<>();
            for(int j=0; j<columna; j++) {
                filaIterada.add((int) (Math.random() * 9) + 0);
            }
            matrizDePrueba.add(filaIterada);
        }
     
        Matriz matriz=new Matriz();
        matriz.setMatriz(matrizDePrueba);
        if(matriz.esMatrizInicializada()){
            System.out.println("-------------------\n"+tiempoAhora+" => APP: matriz original");
            matriz.mostrarMatriz(matriz.getMatriz());
            System.out.println("-------------------\n"+tiempoAhora+" => APP: matriz dividida");
            matriz.mostrarMatriz(matriz.dividir());
            System.out.println("-------------------");
            ArrayList<ArrayList<Integer>> matrizDividida= matriz.dividir();
            int cantidadHilosMatrizDivida= matriz.cantidadDeHilosATener(matrizDividida);
            System.out.println(tiempoAhora+" => APP cantidad hilos a tener: "+cantidadHilosMatrizDivida);
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
            System.out.println("-------------------");
            System.out.println("APP: voy a buscar la suma de hilos al objeto Hilos");
            hilos.mostrarSuma();
        }

    }
}