import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by 123 on 22.10.2016.
 */

public class JavaListTest {

    public void testList(List list) {
        list.add("1");
        list.add("2");
        list.add("3");
        assertTrue(list.size() == 3);
        assertTrue("1".equals(list.get(0)));
        assertTrue("2".equals(list.get(1)));
        assertTrue("3".equals(list.get(2)));
    }

    @Test
    public void testLinkedList() {
        testList(new LinkedList());
    }

    @Test
    public void testArrayList() {
        testList(new ArrayList());
    }
}
