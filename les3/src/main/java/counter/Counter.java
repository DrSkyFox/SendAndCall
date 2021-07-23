package counter;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {
    private Lock lock;
    private static volatile long counter = 0;

    public Counter(Lock lock) {
        this.lock = lock;
    }

    public void increment() {
        lock.lock();
        try {
            counter++;
            Thread.sleep(250);
            System.out.println(Thread.currentThread().getName() + " inc val. Val = " + counter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        increment();
    }

    public long value() {
        return counter;
    }




}
