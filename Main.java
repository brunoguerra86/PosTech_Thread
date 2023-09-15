public class Main {
  public static void main(String[] args) {
      Contador contador = new Contador();

      MinhaThread thread1 = new MinhaThread(contador);
      MinhaThread thread2 = new MinhaThread(contador);

      thread1.start();
      thread2.start();

      try {
          thread1.join();
          thread2.join();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      System.out.println("Valor final: " + contador.getValor());
  }
}