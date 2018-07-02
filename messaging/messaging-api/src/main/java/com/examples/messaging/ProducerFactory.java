package com.examples.messaging;

/**
 * Created by kmiro on 02.07.2018.
 */
public class ProducerFactory {
    public Producer create(String fqcn) {
        try {
            return (Producer) Class.forName(fqcn).newInstance();
        } catch (Exception e) {
            //
        }
        return null;
    }
}
