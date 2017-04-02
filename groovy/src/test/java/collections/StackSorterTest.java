package collections;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.fail;

/**
 * Created by 123 on 27.11.2016.
 */
public class StackSorterTest {

    StackSorter sorter = new StackSorter();

    @Test
    public void test() {
        Stack<Long> stack = new Stack<>();
        stack.push(3L);
        stack.push(7L);
        stack.push(2L);
        stack.push(9L);
        stack.push(23L);
        stack.push(5L);
        stack.push(79L);

        stack = sorter.sort(stack);

        long prev = -1;

        while (!stack.empty()) {
            long top = stack.pop();
            if (top < prev) {
                fail();
            }
            prev = top;
        }


    }
}
