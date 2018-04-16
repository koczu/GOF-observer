package pl.sternik.as.observer;

import java.util.Observable;
import java.util.Observer;

public class TickDisplayer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Tick tick = (Tick) arg;
        System.out.println("WT:Co: " + tick.getName() + " price: " + tick.getPrice());
    }
}
