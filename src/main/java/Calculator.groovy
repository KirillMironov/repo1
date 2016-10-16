/**
 * Created by 123 on 18.09.2016.
 */
@SuppressWarnings("GrMethodMayBeStatic")
class Calculator {

    double calculateSphereVolume(double radius) {
        double volume = 4 / 3 * Math.PI * Math.pow(radius, 3)
        return volume
    }

    double calculateCylinderVolume(double radius, double height) {
        double volume = Math.PI * Math.pow(radius, 2)
        return volume
    }

    int calculateSum(int[][] array) {
        int sum = 0
        for (int row in 0..array.length - 1) {
            for (int col in 0..array[row].length - 1) {
                sum = sum + array[row][col]
            }
        }
        return sum
    }

    int findMaxElement(int[][] array) {
        int maxValue = Integer.MIN_VALUE
        for (int row in 0..array.length - 1) {
            for (int col in 0..array[row].length - 1) {
                if (array[row][col] > maxValue) {
                    maxValue = array[row][col]
                }
            }
        }
        return maxValue
    }

    int[] reversElements(int[] array) {
        int[] reversed = new int[array.length]
        int i5 = array.length - 1
        for (int i in 0..array.length - 1) {
            reversed[r] = array[i]
            r = r - 1
        }
        return reversed
    }
    /*
    0 <- 0
    1 <- 1
    2 <- 2
    3 <- 3
    4 <- 4

    r    i
    4 <- 0
    3 <- 1
    2 <- 2
    1 <- 3
    0 <- 4
     */

    def printPositiveElements(int[] array) {
        for (int i in 0..array.length - 1) {
            if (array[i] > 0) {
                print(array[i] + " ")
            }
        }
    }

}