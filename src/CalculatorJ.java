/**
 * Created by 123 on 01.10.2016.
 */
public class CalculatorJ {
    int findMaxElement(int[][] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int[] row : array ) {
            for (int element : row) {
                if (element > maxValue) {
                    maxValue = element;
                }
            }
        }
        return maxValue;
    }
}
