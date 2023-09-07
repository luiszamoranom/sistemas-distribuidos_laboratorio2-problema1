class Hilo implements Runnable {
    private final int threadId;

    public Hilo(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        System.out.println("Hilo " + threadId + " iniciado.");
        try {
            Thread.sleep(1000); // Demora de 1 segundo para simular actividad
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hilo " + threadId + " finalizado.");
    }
}