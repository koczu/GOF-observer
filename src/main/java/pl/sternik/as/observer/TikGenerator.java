package pl.sternik.as.observer;

import java.util.Iterator;

public class TikGenerator implements Iterable<Tick>{
    private int numberOfTicksToGenerate=0;
    private String tickName;

    public TikGenerator(String tickName, int numberOfTicksToGenerate)
    {
        super();
        this.tickName=tickName;
        this.numberOfTicksToGenerate=numberOfTicksToGenerate;
    }
    @Override
    public Iterator<Tick> iterator() {
        return new Iterator<Tick>() {
            int current=0;
            @Override
            public boolean hasNext() {
                return current < numberOfTicksToGenerate;
            }

            @Override
            public Tick next() {
                current++;
                return new Tick(tickName, Math.random()*100);
            }
        } ;
    }
}
