import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Trava {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean flag = false;

    public void esperar() throws InterruptedException {
        lock.lock();
        try {
            while (!flag) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void notificar() {
        lock.lock();
        try {
            flag = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}