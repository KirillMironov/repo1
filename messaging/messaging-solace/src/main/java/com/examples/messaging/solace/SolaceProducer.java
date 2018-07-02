package com.examples.messaging.solace;

import com.examples.messaging.Producer;
import com.solacesystems.jcsmp.*;

/**
 * Created by kmiro on 02.07.2018.
 */
public class SolaceProducer implements Producer {

    @Override
    public void send(String message, String topic) throws Exception {
        final JCSMPProperties properties = new JCSMPProperties();
        properties.setProperty(JCSMPProperties.HOST, "192.168.0.53");     // host:port
        properties.setProperty(JCSMPProperties.USERNAME, "username"); // client-username
        properties.setProperty(JCSMPProperties.PASSWORD, "password"); // client-password
        properties.setProperty(JCSMPProperties.VPN_NAME, "default"); // message-vpn
        final JCSMPSession session = JCSMPFactory.onlyInstance().createSession(properties);

        session.connect();

        final Topic solaceTopic = JCSMPFactory.onlyInstance().createTopic(topic);

        XMLMessageProducer prod = session.getMessageProducer(new JCSMPStreamingPublishEventHandler() {
            @Override
            public void responseReceived(String messageID) {
                System.out.println("Producer received response for msg: " + messageID);
            }

            @Override
            public void handleError(String messageID, JCSMPException e, long timestamp) {
                System.out.printf("Producer received error for msg: %s@%s - %s%n",
                        messageID, timestamp, e);
            }
        });

        TextMessage msg = JCSMPFactory.onlyInstance().createMessage(TextMessage.class);
        msg.setText(message);
        System.out.printf("Connected. About to send message '%s' to topic '%s'...%n", message, solaceTopic.getName());
        prod.send(msg, solaceTopic);
        System.out.println("Message sent. Exiting.");
        session.closeSession();
    }
}
