package collections;

import org.junit.Test;

/**
 * Created by 123 on 04.12.2016.
 */
public class ArrayTreeTest {
    @Test
    public void test() {
        ArrayTree tree = new ArrayTree();
        tree.set(0, 3, 3);
        tree.set(1, 2, 7);
        tree.set(1, 4, 2);
        tree.set(2, 1, 5);
        tree.set(2, 3, 1);
        tree.set(2, 5, 9);
        tree.set(3, 0, 0);
        tree.set(3, 2, 8);
        tree.set(3, 4, 6);
        tree.set(3, 6, 4);
        tree.nextNode(0, 3);
    }

}
