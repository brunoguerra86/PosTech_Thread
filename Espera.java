public class Espera {
    private boolean flag = false;

    public synchronized void esperar() throws InterruptedException {
        while (!flag){
            wait();
        }
    }

    public synchronized void noitificar(){
        flag = true;
        notifyAll();
    }
}
