public class TesteContador {
    
    // Compartilhamento de informações entre threads
    public static void main(String[] args) {
        Contador contador = new Contador();

        MinhaThread thread1 = new MinhaThread(contador);
        MinhaThread thread2 = new MinhaThread(contador);

        System.out.println("Estado da thread(1): " + thread1.getState()); // NEW
        System.out.println("Estado da thread(2): " + thread2.getState()); // NEW

        thread1.start();
        thread2.start();

        System.out.println("Estado da thread(1): " + thread1.getState()); // RUNNABLE (ou TERMINATED após execução)
        System.out.println("Estado da thread(2): " + thread2.getState()); // RUNNABLE (ou TERMINATED após execução)

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final do contador: " + contador.getContador());
  }
}