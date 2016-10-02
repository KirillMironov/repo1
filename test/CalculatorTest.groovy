/**
 * Created by 123 on 18.09.2016.
 */
class CalculatorTest extends GroovyTestCase {

    final double DELTA = 0.000000001

    def calculator = new Calculator()
    def calculatorJ = new CalculatorJ()

    public void testCalculator() {
        double volume = calculator.calculateSphereVolume(1.0)
        assertEquals(4.188790204786391, volume, DELTA)

        volume = calculator.calculateSphereVolume(2.0)
        assertEquals(33.51032163829112, volume, DELTA)
    }

    public void testCalculateSphereVolume() {
        double volume = calculator.calculateCylinderVolume(1.0, 1.0)
        assertEquals(3.14159265358979323846, volume, DELTA)

        volume = calculator.calculateCylinderVolume(2.0, 2.0)
        assertEquals(25.13274122871834590768, volume, DELTA)
    }

    public void testCalculateSum() {
        int[][] a1 = [
                [0, 1, 3],
                [7, 2, 5],
                [5, 3, 9],
                [2, 6, 8]
        ]

        int sum = calculator.calculateSum(a1)
        assert sum == 51

        int[][] a2 = [
                [0, 1, 3],
                [5, 3, 9],
                [2, 6, 8]
        ]
        sum = calculator.calculateSum(a2)
        assert sum == 37
    }

    public void testFindMaxElement() {
        int[][] a2 = [
                [0, 1, 3],
                [7, 2, 5],
                [5, 3, 9],
                [2, 6, 8]
        ]
        assert calculator.findMaxElement(a2) == 9

        assert calculatorJ.findMaxElement(a2) == 9


        a2 = [
                [0, 1, 3],
                [7, 11, 5],
                [5, 3, 9],
                [2, 6, 8]
        ]
        assert calculator.findMaxElement(a2) == 11


        a2 = [
                [-15, -1, -3],
                [-7, -11, -5],
                [-5, -3, -9],
                [-2, -6, -8]
        ]
        assert calculator.findMaxElement(a2) == -1
    }

    public void testReversElements() {

        int[] a1 = [10, 20, 30, 40, 50]
        int[] reversed = calculator.reversElements(a1)
        assert reversed[0] == 50
        assert reversed[1] == 40
        assert reversed[2] == 30
        assert reversed[3] == 20
        assert reversed[4] == 10


    }

    public void testPrintPositiveElements() {
        int[] a3 = [1, -7, 3, 5, -2]
        calculator.printPositiveElements(a3)
    }

    public void testPI() {
        calculatorJ.calculatePI()
    }


}