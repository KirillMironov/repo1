package collections;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by 123 on 27.11.2016.
 */
public class StackSorter {
    public Stack<Long> sort(Stack<Long> stack) {
        //Collections.sort(stack, Collections.reverseOrder());

        Stack<Long> result = new Stack<>();

        while (!stack.empty()) {
            //Begin
            Stack<Long> temp = new Stack<>();


            long temp1 = -1;
            long temp2 = -1;

            while (!stack.empty()) {
                temp2 = stack.pop();
                if (temp1 > temp2) {
                    if (temp2 >= 0) {
                        temp.push(temp2);
                    }
                } else {
                    if (temp1 >= 0) {
                        temp.push(temp1);
                    }
                    temp1 = temp2;
                }
            }

            result.push(temp1);

            stack = temp;

            //End
        }

        return result;
    }
}
