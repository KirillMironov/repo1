package collections;

import java.util.Arrays;

/**
 * Created by 123 on 04.12.2016.
 */
public class ArrayTree {
    final int ROWS = 4;
    final int COLS = ROWS * 2 - 1;
    private int[][] tree = new int[ROWS][COLS];
    Integer[] winner = new Integer[ROWS];
    Integer[] current = new Integer[ROWS];
    int minSum = Integer.MAX_VALUE;

    public void set(int row, int col, int value) {
        tree[row][col] = value;
    }

    public int sumCurrent() {
        int sum = 0;
        for (int i = 0; i < current.length; i++) {
            sum = sum + current[i];
        }
        return sum;
    }

    public void nextNode(int row, int col) {
        System.out.println(tree[row][col]);
        current[row] = tree[row][col];
        if (row < ROWS - 1) {
            //Это ещё не последний ряд.
            nextNode(row + 1, col - 1);
            nextNode(row + 1, col + 1);
        } else {
            //Это последний ряд.
            int sum = sumCurrent();
            System.out.println(String.format("%s sum = %d", Arrays.asList(current), sum));
            if (sum < minSum) {
                minSum = sum;
                winner = Arrays.copyOf(current, current.length);
            }
            if (row == ROWS - 1 && col == COLS - 1) {
                //Это последний узел дерева. row = 3, col = 6.
                System.out.println(String.format("Winner is: %s sum = %d", Arrays.asList(winner), minSum));
            }
        }
    }

}
