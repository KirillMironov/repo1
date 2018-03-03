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

    String[] ringBuffer = new String[32];

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        String message = "Hello!";

        Thread t1 = new Thread(){
            @Override
            public void run() {
                long next = counter.get()+1;
                int index = (int) (next%32);
                ringBuffer[index] = message;
                counter.incrementAndGet();
            }
        };

        Thread t2 = new Thread(){
            AtomicLong last = new AtomicLong(-1);
            @Override
            public void run() {
                long cntr;
                while ((cntr=counter.get())<=last.get()) {
                    Thread.yield();
                }
                int index = (int) (cntr%32);
                String message = ringBuffer[index];
                log.info(message);
            }
        };

        t2.start();
        t1.start();

        sleep(10000);

        log.info("ok");







    }
}
