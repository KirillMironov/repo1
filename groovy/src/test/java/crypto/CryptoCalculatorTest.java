package crypto;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by 123 on 19.11.2016.
 */
public class CryptoCalculatorTest {
    private CryptoCalculator calculator = new CryptoCalculator();

    @Test
    public void test() {
        assertEquals("ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad", calculator.sha256("abc"));
        assertEquals("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3", calculator.sha256("123"));

        long старт = System.currentTimeMillis();
        for (int i = 1; i < 1000000; i++) {
            calculator.sha256("ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad");
        }
        long стоп = System.currentTimeMillis();
        System.out.println(String.format("%d ms", стоп - старт));
    }
}
