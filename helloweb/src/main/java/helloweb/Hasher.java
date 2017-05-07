package helloweb;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kmiro on 07.05.2017.
 */
public class Hasher {
    public String sha256(String salt, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest((password + ':' + salt).getBytes());
            String hex = Hex.encodeHexString(bytes);
            return hex;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
