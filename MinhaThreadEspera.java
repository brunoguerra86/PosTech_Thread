public class MinhaThreadEspera extends Thread {
    
    /*  Enum de Thread.State:
        
        NEW: a thread foi criada, mas ainda não iniciou sua execução.
        RUNNABLE: a thread está em execução ou pronta para ser executada.
        BLOCKED: a thread está aguardando para adquirir um monitor lock.
        WAITING: a thread está aguardando indefinidamente por outra thread.
        TIMED_WAITING: a thread está aguardando por um período específico.
        TERMINATED: a thread concluiu sua execução ou foi encerrada. 
    */
    
    // ----------------------------------
    // TesteEspera.java
    // ----------------------------------

    private Espera espera;

    public MinhaThreadEspera(Espera espera) {
        this.espera = espera;
    }

    @Override
    public void run() {
        try{
            espera.esperar();
            System.out.println("Thread executando após a espera");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
