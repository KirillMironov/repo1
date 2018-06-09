package concurrent;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by kmiro on 09.06.2018.
 */
public class DateFormatTest {
    Logger log = LoggerFactory.getLogger(getClass());
    //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public Date parse(String s) {
        try {
            return df.get().parse(s);
        } catch (ParseException e) {
            //
        }
        return null;
    }

    @Test
    public void test() throws InterruptedException {
        int count = 10;
        CountDownLatch l1 = new CountDownLatch(count);
        CountDownLatch l2 = new CountDownLatch(count);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    Date date = parse("2018-06-09");
                    //log.info("{}:{}",i,date);
                    assertEquals("Sat Jun 09 00:00:00 MSK 2018", date.toString());
                    l1.countDown();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    Date date = parse("2007-01-01");
                    //log.info("{}:{}",i,date);
                    assertEquals("Mon Jan 01 00:00:00 MSK 2007", date.toString());
                    l2.countDown();
                }
            }
        };

        t1.start();
        t2.start();
        l1.await(1, TimeUnit.MINUTES);
        l2.await(1, TimeUnit.MINUTES);
    }
}
