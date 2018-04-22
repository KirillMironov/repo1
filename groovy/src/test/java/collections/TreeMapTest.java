package collections;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by kmiro on 22.04.2018.
 */
public class TreeMapTest {
    @Test
    public void test() {
        Map<String, String> map = new TreeMap<>();
        map.put("a","apricot");
        map.put("b","banana");
        map.put("c","cherry");

        assertEquals(3,map.size());

        assertEquals("apricot", map.get("a"));
        assertEquals("banana", map.get("b"));
        assertEquals("cherry", map.get("c"));

        assertNull(map.get("x"));

        map.put("c","cantaloupe");
        assertEquals("cantaloupe",map.get("c"));
        assertEquals(3,map.size());

        assertEquals("banana",map.remove("b"));
        assertNull(map.remove("x"));

        assertEquals(2,map.size());
        assertNull(map.get("b"));

        assertTrue(map.containsKey("a"));
        assertFalse(map.containsKey("x"));

        map.clear();
        assertEquals(0,map.size());
        assertNull(map.get("a"));
        assertNull(map.get("b"));
        assertNull(map.get("c"));
    }
}
