import java.util.ArrayList;
import java.util.List;

public class Matriz {
    private ArrayList<ArrayList<Integer>> matriz;
    private boolean matrizInicializada;
    private int cantFilas, cantColumnas;

    /*
     * 1,2,3,4 <-- 4
     * 1,2,3
     * 1,2,3,4
     */
    public Matriz() {
        matrizInicializada = false;
    }

    public boolean matrizValida(ArrayList<ArrayList<Integer>> matriz) {
        int cantidadColumna = -1;
        for (ArrayList<Integer> fila : matriz) {
            /* quiere decir que se analiza por primera vez la primera fila de la matriz */
            if (cantidadColumna == -1) {
                cantidadColumna = fila.size();
            } else {
                /*
                 * si la cantidad de columnas de la primera fila es igual a la cantidad de
                 * columnas
                 * de las filas iteradas, es una matriz valida, en caso contrario, no lo es:
                 */
                if (fila.size() != cantidadColumna) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setMatriz(ArrayList<ArrayList<Integer>> matriz) {
        if (matrizValida(matriz)) {
            this.matriz = matriz;
            matrizInicializada = true;
            /* seteando cantidad filas y columnas */
            cantFilas = this.matriz.size();
            cantColumnas = this.matriz.get(0).size();
            System.out.println("VALIDO SET: matriz definida correctamente, vàlida");
        } else {
            System.out.println("ERROR SET: matriz no valida, por tanto, no se setea en el objeto matriz");
        }
    }

    public void mostrarMatriz(ArrayList<ArrayList<Integer>> matriz) {
        if (matrizInicializada) {
            for (ArrayList<Integer> fila : matriz) {
                for (int valor : fila) {
                    System.out.print(valor + " ");
                }
                System.out.println();
            }
            System.out.println("Cantidad filas: " + cantFilas + " ; cantidad columnas: " + cantColumnas);
        } else {
            System.out.println("ERROR MOSTRAR: La matriz no ha sido inicializada correctamente, nada que mostrar");
        }
    }

    public ArrayList<ArrayList<Integer>> dividir() {
        if (filasMasQueColumnas(this.cantFilas,this.cantColumnas) || columnasIgualQueFilas(this.cantFilas,this.cantColumnas)) {
            return matriz;
        } else { /* columnas mas que filas */
            ArrayList<ArrayList<Integer>> nuevoMatriz = new ArrayList<>();
            for (int columna = 0; columna < cantColumnas; columna++) {
                ArrayList<Integer> filaNueva = new ArrayList<>();
                for (int fila = 0; fila < cantFilas; fila++) {
                    filaNueva.add(matriz.get(fila).get(columna));
                }
                nuevoMatriz.add(filaNueva);
            }
            return nuevoMatriz;
        }
    }

    public int cantidadDeHilosATener(ArrayList<ArrayList<Integer>> matriz) {
        List<Integer> parCantHilos=cantidadHilos(matriz);
        int cantFilas= parCantHilos.get(0);
        int cantColumnas= parCantHilos.get(1);
        if(filasMasQueColumnas(cantFilas, cantColumnas)){
            return cantFilas;
        }else if(columnasIgualQueFilas(cantFilas, cantColumnas)){
            return cantColumnas;
        }
        return cantFilas; // da igual porque seria una matriz cuadrada, retornamos cualquiera
    }

    public List<Integer> cantidadHilos(ArrayList<ArrayList<Integer>> matriz) {
        cantFilas = matriz.size();
        cantColumnas = matriz.get(0).size();

        List<Integer> resultado = new ArrayList<>();
        resultado.add(cantFilas);
        resultado.add(cantColumnas);

        return resultado;
    }

    private boolean filasMasQueColumnas(int cantFilas, int cantColumnas) {
        if (cantFilas > cantColumnas) {
            return true;
        }
        return false;
    }

    private boolean columnasIgualQueFilas(int cantFilas, int cantColumnas) {
        if (cantFilas == cantColumnas) {
            return true;
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>> getMatriz() {
        return matriz;
    }
}
