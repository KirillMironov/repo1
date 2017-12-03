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
    @Test
    public void test2(){
        int a = 9;
        int b = 15;

        float sum = (float) (12 + a + b + Math.pow(5,2));

        int x1 = 1;
        long x2 = 2;

        String s1 = "Hello";
        Integer c = 7;
        String s2 = s1 + c;

        String s3 = s1 +
                c +
                'x' +
                "x";
    }
}


