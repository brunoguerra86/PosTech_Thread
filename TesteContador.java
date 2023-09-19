public class TesteContador {
    
    // Compartilhamento de informações entre threads
    public static void main(String[] args) {
        // o método setDefaultUncaughtExceptionHandler() define o 
        // tratador global de exceções (ExceptionHandler) para todas as threads
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

        Contador contador = new Contador();

        MinhaThreadContador thread1 = new MinhaThreadContador(contador);
        MinhaThreadContador thread2 = new MinhaThreadContador(contador);

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