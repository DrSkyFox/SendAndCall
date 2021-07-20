package pingpong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongMain {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Lock lock = new ReentrantLock();


        PingPong pong = new PingPong("pong", lock);
        PingPong ping = new PingPong("ping", lock);


        executor.execute(pong);
        executor.execute(ping);



    }
}
