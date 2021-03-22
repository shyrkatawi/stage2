package threads.tunnel.entities;

public class Train implements Runnable {
    private boolean isTunnelPassed = false;
    private RailManager railManager;
    private String name;
    private static int id = 1;

    public Train(RailManager railManager) {
        this.railManager = railManager;
        name = "train_" + id;
        id++;
    }

    @Override
    public void run() {
        try {
            railManager.passThroughTheTunnel(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isTunnelPassed() {
        return isTunnelPassed;
    }

    public void tunnelPassed() {
        isTunnelPassed = true;
    }

    @Override
    public String toString() {
        return name;
    }
}
