class Hilos {
    private int cantHilos;

    public Hilos(int cantHilos) {
        this.cantHilos = cantHilos;
    }

    public void crearHilos() {
        for (int i = 1; i <= cantHilos; i++) {
            /*
             * Thread es la clase de Java que crea como tal un hilo
             * en su interior le pasamos un objeto que operará la lógica
             * que realizará cada hilo
             */
            Thread hilo= new Thread(new Hilo(i));
            hilo.start();
        }
    }
}