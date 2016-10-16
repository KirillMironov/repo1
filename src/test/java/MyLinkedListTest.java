import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void testGet() {
        list.addLast("0");
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.addLast("6");

        assertTrue(list.get(3).equals("3"));
        assertTrue(list.get(0).equals("0"));
        assertTrue(list.get(1).equals("1"));
        assertTrue(list.get(5).equals("5"));
        assertNull(list.get(100));
        assertNull(list.get(-3));
    }

    @Test
    public void testRemove() {
        list.addLast("0");
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.addLast("6");

        assertNull(list.remove(-1));
    }

}
