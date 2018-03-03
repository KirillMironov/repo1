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
        //String message = "Hello!";

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (counter.get()<Max-1) {
                    long next = counter.get()+1;
                    int index = (int) (next % BuffSize);
                    ringBuffer[index] = String.format("next=%d index=%d text=%s", next, index, String.valueOf(System.currentTimeMillis()));
                    counter.incrementAndGet();
                }
            }
        };

        Thread t2 = new Thread(){
            AtomicLong last = new AtomicLong(-1);
            @Override
            public void run() {
                while (last.get()<Max-1) {
                    long cntr;
                    while ((cntr = counter.get()) <= last.get()) {
                        Thread.yield();
                    }
                    long next = last.get()+1;
                    int index = (int) (next % BuffSize);
                    String message = ringBuffer[index];
                    log.info(message);
                    last.incrementAndGet();
                }
            }
        };

        t2.start();
        t1.start();

        sleep(10000);

        log.info("ok");

    }
}
