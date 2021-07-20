package pingpong;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class PingPong implements Runnable {

    private String msg;
    private Lock lock;
    private Condition condition;
    private static final int MAXCOUNT = 25;
    private int count = 0;
    private static AtomicBoolean sayPing = new AtomicBoolean();

    public PingPong(String msg, Lock lock) {
        this.msg = msg;
        this.lock = lock;
        condition = lock.newCondition();
        sayPing.set(true);
    }

    @Override
    public void run() {
        while(count <= MAXCOUNT) {
            saidMsg();
        }
    }

    private void saidMsg() {
        lock.lock();
        if(msg.equalsIgnoreCase("ping")) {
            saidPing();
        } else  {
            saidPong();
        }
        count++;

    }

    private void saidPing() {
        try {
            while(!sayPing.get()) {
                condition.await(1, TimeUnit.SECONDS);
            }
            System.out.println(Thread.currentThread().getName() + " said " + msg);

            sayPing.set(false);
            System.out.println(Thread.currentThread().getName() + " Count: " + count + " sayPing: " + sayPing.get());

        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void saidPong() {
        try {
            while(sayPing.get()) {
                condition.await(1, TimeUnit.SECONDS);
            }
            System.out.println(Thread.currentThread().getName() + " said " + msg);
            sayPing.set(true);
            System.out.println(Thread.currentThread().getName() + " Count: " + count + " sayPing: " + sayPing.get());
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
