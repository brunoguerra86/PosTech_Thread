public class MinhaThreadPool extends Thread {
    
    /*  Enum de Thread.State:
        
        NEW: a thread foi criada, mas ainda não iniciou sua execução.
        RUNNABLE: a thread está em execução ou pronta para ser executada.
        BLOCKED: a thread está aguardando para adquirir um monitor lock.
        WAITING: a thread está aguardando indefinidamente por outra thread.
        TIMED_WAITING: a thread está aguardando por um período específico.
        TERMINATED: a thread concluiu sua execução ou foi encerrada. 
    */

    // ----------------------------------
    // TestePool.java
    // ----------------------------------

    private int id;

    public MinhaThreadPool(int id){
        this.id = id;
    }
    
    @Override
    public void run(){
        System.out.println("Thread " + id + " executando");
    }
}
