package concurrent;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * Created by kmiro on 04.03.2017.
 */
public class CountDownLatchTest {

    private void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        //Создать и запустить два потока.Дать имена:Первый - cat. Второй - mouse.
        //Каждый поток в методе run напечатает свое имя.
        //использовать объект класса CountDownLatch для того, что бы первый поток напечатал свое имя ГАРАНТИРОВАННО после второго.
        //Использовать методы  класса CountDownLatch: await и countDown.
        //mouse1, mouse2, cat, mouse3.

        CountDownLatch latch = new CountDownLatch(2);
        Object catLock = new Object();

        Thread cat = new Thread("cat"){
            @Override
            public void run() {
                pause(1000);
                synchronized (catLock) {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getName());
                    catLock.notifyAll();
                }
            }
        };

        Thread mouse1 = new Thread("mouse1"){
            @Override
            public void run() {
                System.out.println(this.getName());
                latch.countDown();
            }
        };

        Thread mouse2 = new Thread("mouse2"){
            @Override
            public void run() {
                System.out.println(this.getName());
                latch.countDown();
            }
        };

        Thread mouse3 = new Thread("mouse3"){
            @Override
            public void run() {
                synchronized (catLock) {
                    try {
                        catLock.wait();//Разомкнуть catLock и ждать сигнала от другого потока.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getName());
                    latch.countDown();
                }
            }
        };

        cat.start();
        mouse1.start();
        mouse2.start();
        mouse3.start();
        pause(1000);
    }



}
