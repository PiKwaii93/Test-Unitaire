package RPNCalculator.src.test.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import RPNCalculator.src.main.java.com.example.RPNCalculator;

public class RPNCalculatorTest {

    @Test
    public void testEvaluateRPN() {
        // Test case 1: Basic addition
        assertEquals(6.0, RPNCalculator.evaluateRPN("4 2 +"));

        // Test case 2: Subtraction
        assertEquals(2.0, RPNCalculator.evaluateRPN("4 2 -"));

        // Test case 3: Multiplication
        assertEquals(8.0, RPNCalculator.evaluateRPN("4 2 *"));

        // Test case 4: Complex expression
        assertEquals(141.0, RPNCalculator.evaluateRPN("3 5 8 * 7 + *"));

        // Add more test cases as needed
    }

    @Test
    public void testInvalidExpression() {
        // Test case: Invalid expression (should throw IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluateRPN("4 +"));

        
        // Test case: Invalid expression (should throw IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluateRPN("4 + 3"));
    }

}
