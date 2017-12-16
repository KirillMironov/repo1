package math;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
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

    public int calculate2x2(int[][] matrix) {
        return calculate(matrix, 0, 0);
    }

    public int[][] get2x2(int[][] matrix, int row, int col) {
        int[][] result = new int[2][2];
        int rr = 0;
        int cc = 0;
        for (int r = 0; r < matrix.length; r++) {
            if (r == row) {
                continue;
            }
            for (int c = 0; c < matrix.length; c++) {
                if (c == col) {
                    continue;
                }
                result[rr][cc] = matrix[r][c];
                cc++;
            }
            cc = 0;
            rr++;
        }
        return result;
    }

    @Test
    public void test() {
        /*1) Матрица произвольного размера int[][],
        * 2) row <= Matrix.size-2,
        * 3) col <= Matrix.size-2,
        * 4) Вернуь: a*d-b*c */
        int[][] matrix = {
                {-9, 1, 0, 3},
                {4, 1, 1, -5},
                {-2, 2, -1, 7},
                {-1, 9, -4, 8}
        };
        int result = calculate(matrix, 2, 2);
        assertEquals(20, result);
        result = calculate(matrix, 1, 1);
        assertEquals(-3, result);
    }

    @Test
    public void testGet2x2() {
        int[][] matrix = {
                {1, 2, 3,},
                {4, 5, 6,},
                {7, 8, 9,}
        };

        int[][] result = get2x2(matrix, 0, 0);
        assertArrayEquals(new int[][]{
                {5, 6},
                {8, 9}
        }, result);

        result = get2x2(matrix, 1, 1);
        assertArrayEquals(new int[][]{
                {1, 3},
                {7, 9}
        }, result);

        result = get2x2(matrix, 2, 2);
        assertArrayEquals(new int[][]{
                {1, 2},
                {4, 5}
        }, result);
    }

    public int calculate3x3(int[][] matrix) {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            int[][] m = get2x2(matrix, 0, i);
            int value = matrix[0][i] * calculate2x2(m);
            if (i % 2 == 1) {
                result = result - value;
            } else {
                result = result + value;
            }
        }

        return result;
    }

    @Test
    public void testCalculate3x3() {
        int[][] matrix = {
                {1, 2, 3,},
                {4, 5, 6,},
                {7, 8, 9,}
        };

        int result = calculate3x3(matrix);
        assertEquals(0, result);
    }
}
