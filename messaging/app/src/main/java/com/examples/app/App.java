package com.examples.app;

import com.solacesystems.jcsmp.*;
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
        send(t);
    }

    public void doSend(double temperature) throws Exception {
        final JCSMPProperties properties = new JCSMPProperties();
        properties.setProperty(JCSMPProperties.HOST, "192.168.0.53");     // host:port
        properties.setProperty(JCSMPProperties.USERNAME, "username"); // client-username
        properties.setProperty(JCSMPProperties.PASSWORD, "password"); // client-password
        properties.setProperty(JCSMPProperties.VPN_NAME, "default"); // message-vpn
        final JCSMPSession session =  JCSMPFactory.onlyInstance().createSession(properties);

        session.connect();

        final Topic topic = JCSMPFactory.onlyInstance().createTopic("tutorial/topic");

        XMLMessageProducer prod = session.getMessageProducer(new JCSMPStreamingPublishEventHandler() {
            @Override
            public void responseReceived(String messageID) {
                System.out.println("Producer received response for msg: " + messageID);
            }
            @Override
            public void handleError(String messageID, JCSMPException e, long timestamp) {
                System.out.printf("Producer received error for msg: %s@%s - %s%n",
                        messageID,timestamp,e);
            }
        });

        TextMessage msg = JCSMPFactory.onlyInstance().createMessage(TextMessage.class);
        final String text = String.format("t=%f", temperature);
        msg.setText(text);
        System.out.printf("Connected. About to send message '%s' to topic '%s'...%n",text,topic.getName());
        prod.send(msg,topic);
        System.out.println("Message sent. Exiting.");
        session.closeSession();
    }

    public void send(double temperature) {
        try{
            doSend(temperature);
        }catch (Exception e) {
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
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(new Task(),1000,5000L, TimeUnit.MILLISECONDS);

    }
}
