package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kmiro on 09.12.2017.
 */
public class MatrixTest {
    public int calculate(int[][] matrix, int row, int col) {
        int a = matrix[row][col];
        int b = matrix[row + 1][col];
        int c = matrix[row][col + 1];
        int d = matrix[row + 1][col + 1];
        return a * d - b * c;
    }

    @Test
    public void test() {
        /*1) Матрица произвольного размера int[][],
        * 2) row <= Matrix.size-2,
        * 3) col <= Matrix.size-2,
        * 4) Вернуь: a*d-b*c */
        int[][] matrix = {
                {-9,1,0,3},
                {4,1,1,-5},
                {-2,2,-1,7},
                {-1,9,-4,8}
        };
        int result = calculate(matrix,2,2);
        assertEquals(20, result);
        result = calculate(matrix,1,1);
        assertEquals(-3, result);
    }
}
