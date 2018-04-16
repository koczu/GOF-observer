package pl.sternik.as.observer;

import java.util.Observable;
public final class GpwServer extends Observable 
implements ServerStockDatas {

    private final Tick[] ticks;
    private final int counterMax = 10;
    private int counter;

    public GpwServer() {
        ticks = new Tick[counterMax];
        ticks[0] = new Tick("KGH", 10);
        ticks[1] = new Tick("WWL", 1);
        ticks[2] = new Tick("PKO", 100);
        ticks[3] = new Tick("PKO", 120);
        ticks[4] = new Tick("WWL", 1.1);
        ticks[5] = new Tick("KGH", 10.6);
        ticks[6] = new Tick("PKO", 123);
        ticks[7] = new Tick("PKN", 34.5);
        ticks[8] = new Tick("ATN", 21.5);
        ticks[9] = new Tick("KGH", 11.1);
    }

    private Tick downloadTick() {
        if (counter >= counterMax) {
            counter = 0;
        }
        return ticks[counter++];
    }

    @Override
    public void simulateTransaction() {
        setChanged();
        notifyObservers(downloadTick());
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

}
