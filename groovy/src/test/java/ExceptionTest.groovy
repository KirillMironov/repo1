/**
 * Created by 123 on 06.11.2016.
 */
class ExceptionTest extends GroovyTestCase {
    public static final int ARIFMETIC_ERROR = -1
    public static final int OK = 0

    class DoubleResult {
        double value

        DoubleResult() {
        }

        DoubleResult(double value) {
            this.value = value
        }
    }

    public int calculateWithNoExceptions(double x, double y, DoubleResult result) {
        if (y == 0.0) {
            return ARIFMETIC_ERROR
        }
        result.value = x / y
        return OK
    }

    public double calculate(double x, double y) {
        return BigDecimal.valueOf(x).divide(y).doubleValue()
    }

    public void calculate() {
        throw new Exception()
    }

    public void testWithNoExceptions() {
        DoubleResult result = new DoubleResult()
        int returnCode = calculateWithNoExceptions(100.0, 0.0, result)
        if (returnCode == OK) {
            println(result.value)
        } else {
            println("ERROR")
        }
    }

    public void test() {
        def x = 0
        try {
            x = calculate(100.0, 0.0)
            println(x)
        }catch(Exception e) {
            println("ERROR " + e.getMessage())
        }
    }
}
