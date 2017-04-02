import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 123 on 25.12.2016.
 */
public class CalculatorJTest {
    CalculatorJ calc = new CalculatorJ();
    @Test
    public void fibonacci() throws Exception {
        assertTrue(calc.fibonacci(0) == 0);
        assertTrue(calc.fibonacci(1) == 1);
        assertTrue(calc.fibonacci(2) == 1);
        assertTrue(calc.fibonacci(3) == 2);
        assertTrue(calc.fibonacci(4) == 3);
        assertTrue(calc.fibonacci(10) == 55);
    }

}