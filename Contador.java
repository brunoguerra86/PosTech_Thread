public class Contador {
  private int valor = 0;

  public synchronized void incrementar() {
      valor++;
  }
}