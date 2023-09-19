import java.util.ArrayList;
import java.util.List;

public class ThreadExample {
  
/*  Neste exemplo, temos um programa que utiliza duas threads: uma produtora e
    uma consumidora. A lista `sharedList` é compartilhada entre as threads e é utilizada
    para troca de dados. O objeto `mutex` é utilizado como um mecanismo de
    sincronização para garantir acesso exclusivo à lista.
    
    A thread produtora adiciona números de 1 a 10 à lista, enquanto a thread
    consumidora remove os números da lista, desde que a lista não esteja vazia. As
    threads são sincronizadas por meio do uso do mutex, permitindo que uma thread
    acesse a lista de cada vez.
    
    O tratamento de exceções é realizado por meio do bloco try-catch em cada
    thread. Caso uma exceção seja lançada durante a execução da thread, o stack trace
    da exceção é impresso. */

    public static void main(String[] args) {
      // Criando uma lista compartilhada
      List<Integer> sharedList = new ArrayList<>();

      // Criando um objeto para sincronizar o acesso à lista
      Object mutex = new Object();

      // Criando uma thread produtora
      Thread producerThread = new Thread(() -> {
          try {
              // Produzindo dados
              for (int i = 1; i <= 10; i++) {
                  // Adquirindo o mutex para acesso exclusivo à lista
                  synchronized (mutex) {
                      // Adicionando um elemento à lista
                      sharedList.add(i);
                      System.out.println("Produtor adicionou: " + i);
                  }

                  // Aguardando um curto período de tempo antes de produzir o próximo dado
                  Thread.sleep(100);
              }
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      });

      // Criando uma thread consumidora
      Thread consumerThread = new Thread(() -> {
          try {
              // Consumindo dados
              for (int i = 0; i < 10; i++) {
                  // Adquirindo o mutex para acesso exclusivo à lista
                  synchronized (mutex) {
                      // Verificando se há elementos na lista para consumir
                      if (!sharedList.isEmpty()) {
                          // Removendo um elemento da lista
                          int value = sharedList.remove(0);
                          System.out.println("Consumidor removeu: " + value);
                      }
                  }

                  // Aguardando um curto período de tempo antes de consumir o próximo dado
                  Thread.sleep(200);
              }
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      });

      // Iniciando as threads
      producerThread.start();
      consumerThread.start();
  }
}