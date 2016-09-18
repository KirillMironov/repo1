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
            for (int col in 0..array[0].length - 1) {
                sum = sum + array[row][col]
            }
        }
        return sum
    }


}
