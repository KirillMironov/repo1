package collections;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by kmiro on 02.12.2017.
 */
public class DeduplicateArrayTest {
    public Integer[] deduplicate(int[] x){
        ArrayList result = new ArrayList();
        for (int i = 0; i < x.length; i++) {
            if (!result.contains(x[i])){
                result.add(x[i]);
            }
        }
        return (Integer[]) result.toArray(new Integer[result.size()]);
    }
    @Test
    public void test(){
        int[] y = {2, 5, 2, 3, 0, 5, 6, 3};
        Integer[] k = deduplicate(y);
        System.out.print("");

    }
}


