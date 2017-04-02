package crypto;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.SHA256Digest;

/**
 * Created by 123 on 19.11.2016.
 */
@SuppressWarnings("WeakerAccess")
public class CryptoCalculator {
    public String sha256(String message) {
        byte[] input = message.getBytes();
        SHA256Digest d = new SHA256Digest();
        d.update(input, 0, input.length);
        byte[] result = new byte[d.getDigestSize()];
        d.doFinal(result, 0);
        return Hex.encodeHexString(result);
    }
}
