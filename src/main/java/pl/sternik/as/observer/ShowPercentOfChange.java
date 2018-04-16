package pl.sternik.as.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ShowPercentOfChange implements Observer {

    private final Map<String, Tick> lastTiks = new HashMap<String, Tick>();

    @Override
    public void update(Observable o, Object arg) {
        Tick tick = (Tick) arg;
        Tick tickOld = lastTiks.get(tick.getName());
        if (tickOld != null) {
            double change = ((tick.getPrice() - tickOld.getPrice()) / tickOld.getPrice()) * 100;
            System.out.println("PZ:Co: " + tick.getName() + " change: " + change + "%");
        }
        lastTiks.put(tick.getName(), tick);
    }
}