package collections;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by kmiro on 08.04.2018.
 */
public class ArrayBlockingQueueTest {
    Queue<String> queue = new ArrayBlockingQueue<>(4);

    @Test
    //Успешный сценарий добавления строк в очередь.
    public void offerSuccess() {
        for (int i = 0; i < 4; i++) {
            queue.add("Строка:" + i);
        }
        assertEquals(4, queue.size());
    }

    @Test(expected = IllegalStateException.class)
    //Неуспешный сценарий добавления строк в очередь.
    public void offerFailure() {
        for (int i = 0; i < 5; i++) {
            queue.add("Строка:" + i);
        }
    }

    @Test
    public void peek() {
        for (int i = 0; i < 4; i++) {
            queue.add("Строка:" + i);
        }
        String s = queue.peek();
        assertEquals("Строка:0", s);
        assertEquals(4, queue.size());
    }

    @Test
    public void remove() {
        for (int i = 0; i < 4; i++) {
            queue.add("Строка:" + i);
        }
        String s = queue.remove();
        assertEquals(3, queue.size());
        assertEquals("Строка:0", s);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFail() {
        queue.remove();
    }

    @Test
    public void pollReturnsNull() {
        String s = queue.poll();
        assertNull(s);
        assertEquals(0, queue.size());
    }
}
