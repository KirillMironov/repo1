package helloweb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kmiro on 07.05.2017.
 */
public class HasherTest {
    Hasher hasher = new Hasher();
    @Test
    public void test() {
        assertEquals("d828a111012c4acd875a22b8b88671c31b62e4cf4cedbd38eed973bf0def6e1a", hasher.sha256("5DE8FFC38B2E1", "london"));
        assertEquals("1209851e6ebf7afb2c8813c266ab7154dcbc451432b30d4c31161a180b6cb8cd", hasher.sha256("DB7FF31A7E192", "london"));
    }
}
