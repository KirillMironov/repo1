import java.util.Random;

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

    double calculatePI() {
        // S1 = (2 * R)^2
        // S2 = PI * R^2

        // S1/S2 = (2 * R)^2 / PI * R^2
        // PI = (2 * R)^2 / (S1/S2) / R^2
        Random X = new Random();
        Random Y = new Random();
        double S1 = 0.0;
        double S2 = 0.0;
        for(int i = 0; i < 1000000; i++) {
            double x = X.nextDouble();
            double y = Y.nextDouble();
            //System.out.println(String.format("x = %s y = %s", x, y));
            //расстояние от центра
            double d = Math.sqrt(x * x + y * y);
            if(d < 1.0) {
                S1++;
                S2++;
            }else {
                S1++;
            }
        }
        double R = 1.0;
        double PI = (2 * R) * (2 * R) / (S1/S2) / (R * R);
        System.out.println(PI);


    return 0.0;
    }

    public int fibonacci(int n) {
        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
