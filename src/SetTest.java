import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import java.util.TreeSet;

/**
 * Created by 123 on 02.10.2016.
 */
public class SetTest {
    @Test
    public void test() {
        TreeSet set = new TreeSet();
        set.add("green");
        set.add("red");
        set.add("blue");
        set.add("brown");
        System.out.println(set);
        set.add("black");
        set.add("black");
        //set.add(Integer.valueOf(3));
        System.out.println(set);
        set.remove("brown");
        System.out.println(set);
        set.clear();
        System.out.println(set);
    }
    @Test
    public void testHex() throws DecoderException {
        Hex codec = new Hex();
        String hex = Hex.encodeHexString("abc".getBytes());
        System.out.println(hex);
        byte[] bytes = codec.decode("78797A".getBytes());
        String s = new String(bytes);
        System.out.print(s);
    }
}
