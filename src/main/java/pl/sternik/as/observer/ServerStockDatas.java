package pl.sternik.as.observer;

import java.util.Observer;

public interface ServerStockDatas {
    void addObserver(Observer o);

    void simulateTransaction();
}
