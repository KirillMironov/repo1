package com.examples.messaging;

/**
 * Created by kmiro on 02.07.2018.
 */
public interface Producer {
    void send(String message, String topic) throws Exception;
}
