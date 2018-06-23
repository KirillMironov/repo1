package com.examples.app;

import org.junit.Test;

/**
 * Created by kmiro on 23.06.2018.
 */
public class AppTest {
    App app = new App();

    @Test
    public void test() throws InterruptedException {
        app.start();
        Thread.sleep(99000);
    }
}
