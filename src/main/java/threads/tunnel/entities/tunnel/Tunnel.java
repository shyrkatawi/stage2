package threads.tunnel.entities.tunnel;

import threads.tunnel.entities.Train;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Tunnel {
    private static final int PERMITS_NUMBER = 1;
    private static int id = 1;
    private String name;
    private Semaphore semaphore;

    public Tunnel() {
        name = "tunnel_" + id;
        id++;
        semaphore = new Semaphore(PERMITS_NUMBER, true);
    }

    public boolean tryPassTunnel(Train train, int timeOut) throws InterruptedException {
        System.out.println(train + " is trying pass the " + name + " queue:" + getNumberOfTrainsInQueue());
        if (semaphore.tryAcquire(timeOut, TimeUnit.SECONDS)) {
            System.out.println(train + " started moving through the " + name);
            TimeUnit.SECONDS.sleep(2);
            train.tunnelPassed();
            System.out.println(train + " passed the " + name);
            semaphore.release();
            return true;
        } else {
            System.out.println(name + " is busy for " + train + ", trying next tunnel");
            return false;
        }
    }

    public int getNumberOfTrainsInQueue() {
        return semaphore.getQueueLength();
    }
}
