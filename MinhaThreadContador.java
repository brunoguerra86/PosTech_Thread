public class MinhaThreadContador extends Thread {
    
    /*  Enum de Thread.State:
        
        NEW: a thread foi criada, mas ainda não iniciou sua execução.
        RUNNABLE: a thread está em execução ou pronta para ser executada.
        BLOCKED: a thread está aguardando para adquirir um monitor lock.
        WAITING: a thread está aguardando indefinidamente por outra thread.
        TIMED_WAITING: a thread está aguardando por um período específico.
        TERMINATED: a thread concluiu sua execução ou foi encerrada. 
    */
    
    // ----------------------------------
    // TesteContador.java    
    // ----------------------------------
    
    private Contador contador;

    public MinhaThreadContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        System.out.println("Thread em execução");
        
        for(int i = 0; i < 10000; i++){
            contador.incrementar();
        }        
    }
}
