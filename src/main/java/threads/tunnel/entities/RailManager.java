package threads.tunnel.entities;

import threads.tunnel.entities.tunnel.Tunnel;

public class RailManager {
    private Tunnel[] tunnels = new Tunnel[2];

    public RailManager() {
        for (int i = 0; i < tunnels.length; i++) {
            tunnels[i] = new Tunnel();
        }
    }

    public void passThroughTheTunnel(Train train) throws InterruptedException {
        while (!train.isTunnelPassed()){
            for (Tunnel tunnel : tunnels) {
                if(tunnel.tryPassTunnel(train, 3)) {
                    break;
                }
            }
        }
    }
}
