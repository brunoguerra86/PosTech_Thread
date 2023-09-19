public class MinhaThreadTrava extends Thread {
    private Trava trava;

    public MinhaThreadTrava(Trava trava) {
        this.trava = trava;
    }

    @Override
    public void run() {
        try {
            trava.esperar();
            System.out.println("Thread executando após a espera");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}