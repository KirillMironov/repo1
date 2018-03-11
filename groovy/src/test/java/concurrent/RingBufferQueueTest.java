package concurrent;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.sleep;

/**
 * Created by kmiro on 11.03.2018.
 */
public class RingBufferQueueTest {
    private Logger log = LoggerFactory.getLogger(getClass());
    private Queue<String> queue = new RingBufferQueue();
    private final int Max = 11;

    @Test
    public void test() throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < Max; i++) {
                    queue.offer(String.format("text=%s", String.valueOf(System.currentTimeMillis())));
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                int counter = 0;
                while (counter < Max) {
                    String message = queue.poll();
                    log.info(message);
                    counter++;
                }
            }
        };

        t2.start();
        t1.start();

        sleep(10000);

        log.info("ok");
    }
}
