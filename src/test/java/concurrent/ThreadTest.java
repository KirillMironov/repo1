package concurrent;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


    @Test
    public void test() {
        log.info("Hello!");
        Thread thread1 = new Thread("thread1") {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    log.info("*" +i);
                    pause(10);
                }
            }
        };

        Thread thread2 = new Thread("thread2") {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    log.info("*" +i);
                    pause(10);
                }
            }
        };
        thread1.start();
        thread2.start();
        pause(100);
    }
}
