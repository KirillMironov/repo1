package lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kmiro on 18.02.2018.
 */
public class BinaryTest {
    Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void test() {
        int b = Integer.MIN_VALUE+1;
        int r = b << 1;
        log.info("b={} {}", b, Integer.toBinaryString(b));
        log.info("r={} {}", r, Integer.toBinaryString(r));
    }
}
