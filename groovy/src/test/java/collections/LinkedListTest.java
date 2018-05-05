package collections;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by kmiro on 05.05.2018.
 */
public class LinkedListTest {
    @Test
    public void test() {
        List<String> names = new LinkedList<>();
        names.add("Harry");
        names.add("Bob");
        names.add("Tom");
        names.add("Steve");

        //System.out.println("Names: " + names);
        assertEquals(4,names.size());

        assertEquals("Harry", names.get(0));
        assertEquals("Bob", names.get(1));
        assertEquals("Tom", names.get(2));
        assertEquals("Steve", names.get(3));

        names.add("Ron");
        assertEquals(5,names.size());
        assertEquals("Ron", names.get(4));

        names.remove(2);
        assertEquals(4,names.size());
        assertEquals("Steve", names.get(2));

        names.clear();
        assertEquals(0,names.size());

        //------------------------------------------------

        List<String> cities = new LinkedList<>();
        cities.add(0, "Smolensk");
        cities.add(1, "Moscow");
        cities.add(2, "Vancouver");
        cities.add(3, "Raleigh");

        assertEquals(4,cities.size());

        assertEquals("Smolensk", cities.get(0));
        assertEquals("Moscow", cities.get(1));
        assertEquals("Vancouver", cities.get(2));
        assertEquals("Raleigh", cities.get(3));

        cities.add(1, "Rome");
        assertEquals("Rome",cities.get(1));
        assertEquals(5,cities.size());

        cities.remove("Rome");
        assertEquals(4,cities.size());
        assertEquals("Moscow",cities.get(1));
    }
}
