public class Contador {
    private int contador = 0;

    public synchronized void incrementar() {
        contador++;
    }

    public synchronized void decrementar() {
        contador--;
    }

    public int getContador() {
        return contador;
    }  
}