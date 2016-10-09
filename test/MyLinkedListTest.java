import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by 123 on 08.10.2016.
 */
public class MyLinkedListTest {

    MyLinkedList list = new MyLinkedList();

    @Test
    public void testCreate() {
        assertEquals(0, list.size());
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testAddFirst() {
        list.addFirst("red");
        assertTrue(list.head == list.tail);
        assertTrue(list.size() == 1);

        list.addFirst("green");
        assertTrue(list.getFirst().equals("green"));
        assertTrue(list.getLast().equals("red"));
        assertTrue(list.size() == 2);
    }

    @Test
    public void testAddLast() {
        list.addLast("red");
        assertTrue(list.tail == list.head);
        assertTrue(list.size() == 1);

        list.addLast("green");
        assertTrue(list.getFirst().equals("red"));
        assertTrue(list.getLast().equals("green"));
        assertTrue(list.size() == 2);

        list.addLast("black");
        assertTrue(list.getFirst().equals("red"));
        assertTrue(list.getLast().equals("black"));
        assertTrue(list.size() == 3);
    }

}
