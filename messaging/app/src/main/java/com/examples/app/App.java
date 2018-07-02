package com.examples.app;

import com.examples.messaging.Producer;
import com.examples.messaging.ProducerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Created by kmiro on 23.06.2018.
 */
public class App {
    Logger logger = LoggerFactory.getLogger(getClass());
    Producer producer;

    public double readTemperature() {
        return 30.0;
    }

    public void task() {
        double t = readTemperature();
        logger.info("t={}", t);
        send(t);
    }

    public void doSend(double temperature) throws Exception {
        final String message = String.format("t=%f", temperature);
        producer.send(message, "tutorial/topic");
    }

    public void send(double temperature) {
        try {
            doSend(temperature);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private class Task implements Runnable {
        @Override
        public void run() {
            task();
        }
    }

    public void start() {
        producer = new ProducerFactory().create("com.examples.messaging.solace.SolaceProducer");
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(new Task(), 1000, 5000L, TimeUnit.MILLISECONDS);
    }
}
