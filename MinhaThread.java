public class MinhaThread extends Thread {
  private Contador contador;

  public MinhaThread(Contador contador) {
      this.contador = contador;
  }

  @Override
  public void run() {
      contador.incrementar();
  }
}