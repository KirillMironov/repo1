package concurrent;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by 123 on 20.11.2016.
 */
public class ThreadTest {
    Logger log = LoggerFactory.getLogger(getClass());

    private void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Random random = new Random();

    private long random() {
        return Math.abs(random.nextLong()%10);
    }

    long x = 0;

    final Object lock = new Object();

    @Test
    public void test() {
        log.info("Hello!");

        Thread thread1 = new Thread("thread1") {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        x = x + 1;
                    }
                    log.info("*" +i);
                    pause(10);
                }
            }
        };

        Thread thread2 = new Thread("thread2") {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        x = x + 1;
                    }
                    log.info("*" +i);
                    pause(10);
                }
            }
        };
        thread1.start();
        thread2.start();
        pause(1000);
        log.info("x =" + x);
    }
}
