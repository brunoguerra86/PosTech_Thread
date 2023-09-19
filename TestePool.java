import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestePool {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 5; i++){
            executor.execute(new MinhaThreadPool(i));
        }

        executor.shutdown();
    }
}
