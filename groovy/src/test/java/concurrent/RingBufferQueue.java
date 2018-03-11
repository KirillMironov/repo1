package concurrent;


import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kmiro on 11.03.2018.
 */
public class RingBufferQueue extends AbstractQueue<String> {
    private final int BuffSize = 8;

    private String[] ringBuffer = new String[BuffSize];

    private AtomicLong tailCounter = new AtomicLong(-1);
    private AtomicLong headCounter = new AtomicLong(-1);

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(String s) {
        long next = tailCounter.get() + 1;
        int index = (int) (next % BuffSize);
        ringBuffer[index] = s;
        tailCounter.incrementAndGet();
        return true;
    }

    @Override
    public String poll() {
        long cntr;
        while ((cntr = tailCounter.get()) <= headCounter.get()) {
            Thread.yield();
        }
        long next = headCounter.get() + 1;
        int index = (int) (next % BuffSize);
        String message = ringBuffer[index];
        headCounter.incrementAndGet();
        return message;
    }

    @Override
    public String peek() {
        return null;
    }
}
