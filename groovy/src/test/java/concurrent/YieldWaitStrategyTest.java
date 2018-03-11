package concurrent;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kmiro on 03.03.2018.
 */
public class YieldWaitStrategyTest {

    Logger log = LoggerFactory.getLogger(getClass());

    AtomicLong counter = new AtomicLong(-1);

    final int Max = 11;

    final int BuffSize = 8;

    String[] ringBuffer = new String[BuffSize];

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        //Producer
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (counter.get() < Max - 1) {
                    long next = counter.get() + 1;
                    int index = (int) (next % BuffSize);
                    ringBuffer[index] = String.format("next=%d index=%d text=%s", next, index, String.valueOf(System.currentTimeMillis()));
                    counter.incrementAndGet();
                }
            }
        };

        //Consumer
        Thread t2 = new Thread() {
            AtomicLong consumerCounter = new AtomicLong(-1);

            @Override
            public void run() {
                while (consumerCounter.get() < Max - 1) {
                    long cntr;
                    while ((cntr = counter.get()) <= consumerCounter.get()) {
                        Thread.yield();
                    }
                    long next = consumerCounter.get() + 1;
                    int index = (int) (next % BuffSize);
                    String message = ringBuffer[index];
                    log.info(message);
                    consumerCounter.incrementAndGet();
                }
            }
        };

        t2.start();
        t1.start();

        sleep(10000);

        log.info("ok");

    }
}
