package pl.sternik.as.observer;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public final class GpwServerSubscriptionController extends Observable implements Observer, ServerStockDatas {
    private final ServerStockDatas gpwServer;
    private final Set<String> tickPayerd = new HashSet<String>();

    public GpwServerSubscriptionController(ServerStockDatas server, String shareName) {
        this.gpwServer = server;
        server.addObserver(this);
        tickPayerd.add(shareName);
    }

    @Override
    public void update(Observable o, Object arg) {
        Tick tick = (Tick) arg;
        if (tickPayerd.contains(tick.getName())) {
            setChanged();
            notifyObservers(tick);
        }
    }

    @Override
    public void simulateTransaction() {
        gpwServer.simulateTransaction();
    }
}