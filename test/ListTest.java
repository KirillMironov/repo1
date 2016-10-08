import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by 123 on 08.10.2016.
 */
public class ListTest {
    public void print(List list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) +" ");
        }
        System.out.println();
    }
    @Test
    public void test() {
        LinkedList list = new LinkedList();
        list.add("green");
        list.add("red");
        list.add("blue");
        list.add("brown");
        print(list);
        list.add("black");
        list.add("yellow");
        list.add("black");
        //set.add(Integer.valueOf(3));
        print(list);
        list.remove("brown");
        print(list);
        list.clear();
        print(list);
    }
}
