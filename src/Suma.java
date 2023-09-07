public class Suma {
    private int total;

    public Suma(){
        total=0;
    }

    public void sumar(int agregado){
        total+=agregado;
    }

    public int getSuma(){
        return total;
    }
}
