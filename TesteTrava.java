public class TesteTrava {
    public static void main(String[] args) {
        Trava trava = new Trava();

        MinhaThreadTrava thread = new MinhaThreadTrava(trava);
        thread.start();

        try {
            Thread.sleep(2000); // Espera por 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        trava.notificar();
    }
}