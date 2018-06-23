package com.examples.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Created by kmiro on 23.06.2018.
 */
public class App {
    Logger logger = LoggerFactory.getLogger(getClass());
    public double readTemperature() {
        return 30.0;
    }

    public void task() {
        double t = readTemperature();
        logger.info("t={}",t);
    }

    private class Task implements Runnable {
        @Override
        public void run() {
            task();
        }
    }

    public void start() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(new Task(),1000,5000L, TimeUnit.MILLISECONDS);

    }
}
