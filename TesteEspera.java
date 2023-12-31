public class TesteEspera {

    // Utilização de mecanismos de espera e notificação
    public static void main(String[] args){
        Espera espera = new Espera();

        MinhaThreadEspera thread = new MinhaThreadEspera(espera);

        thread.start();

        try{
            Thread.sleep(2000); // Espera por 2 segundos
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        espera.noitificar();
    }
}
