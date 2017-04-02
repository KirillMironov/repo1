package collections;

import org.junit.Test;

/**
 * Created by kmiro on 25.02.2017.
 */
public class RingBufferTest {
    RingBuffer rb = new RingBuffer(10);
    @Test
    public void test() {
        for (int i=0; i<7; i++){
            rb.write(String.valueOf(i));
        }

        String s = rb.read();
        System.out.println(s);

        for (int i=0; i<4; i++){
            rb.write(String.valueOf(i));
        }
    }

}
