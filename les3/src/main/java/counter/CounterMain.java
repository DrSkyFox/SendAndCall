package counter;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterMain {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        while(true) {
            executor.submit(new Counter(lock));
            executor.submit(new Counter(lock));
        }
    }
}
