import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by 123 on 16.10.2016.
 */
public class MyQueueTest {
    MyQueue queue = new MyQueue();
    @Test
    public void testOffer() {
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        assertTrue(queue.size() == 3);
        assertTrue(queue.poll().equals("1"));
        assertTrue(queue.poll().equals("2"));
        assertTrue(queue.poll().equals("3"));
    }

    @Test
    public void testPeek() {
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        assertTrue(queue.size() == 3);
        assertTrue(queue.peek().equals("1"));
        assertTrue(queue.size() == 3);
        assertTrue(queue.peek().equals("1"));

    }
}
