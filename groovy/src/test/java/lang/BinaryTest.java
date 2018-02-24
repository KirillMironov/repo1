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

    @Test
    public  void test2(){
        boolean b1;
        boolean b2;
        boolean b3;
        boolean b4;
        short flags = 0b100000000;
        log.info("flags={} {}", flags, Integer.toBinaryString(flags));
        final byte B1 = 0b00000001;
        final byte B2 = 0b00000010;
        final byte B3 = 0b00000100;
        final byte B4 = 0b00001000;
        flags = (short) (flags | B3);
        log.info("flags={} {}", flags, Integer.toBinaryString(flags));
        flags = (short) (flags | B1);
        log.info("flags={} {}", flags, Integer.toBinaryString(flags));
        boolean b3set = (flags & B3) > 0;
        log.info("b3set={}", b3set);
        boolean b2set = (flags & B2) > 0;
        log.info("b2set={}", b2set);
        flags = (short) (flags & B2);
        log.info("*flags={} {}", flags, Integer.toBinaryString(flags));
        flags = (short) (flags & ~B1);
        log.info("flags={} {}", flags, Integer.toBinaryString(flags));
        flags = (short) (flags & ~B3);
        log.info("flags={} {}", flags, Integer.toBinaryString(flags));
    }
}
