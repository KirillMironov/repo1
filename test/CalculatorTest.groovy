/**
 * Created by 123 on 18.09.2016.
 */
class CalculatorTest extends GroovyTestCase {

    final double DELTA = 0.000000001

    def calculator = new Calculator()

    public void testCalculator() {
        double volume = calculator.calculateSphereVolume(1.0)
        assertEquals(4.188790204786391, volume, DELTA )

        volume = calculator.calculateSphereVolume(2.0)
        assertEquals(33.51032163829112, volume, DELTA)
    }


}