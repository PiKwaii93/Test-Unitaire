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

        // Additional test cases
        assertEquals(10.0, RPNCalculator.evaluateRPN("7 3 +"));
        assertEquals(-5.0, RPNCalculator.evaluateRPN("-2 -3 +"));
        assertEquals(4.0, RPNCalculator.evaluateRPN("7 3 -"));
        assertEquals(1.0, RPNCalculator.evaluateRPN("2 1 -"));
        assertEquals(21.0, RPNCalculator.evaluateRPN("7 3 *"));
        assertEquals(-6.0, RPNCalculator.evaluateRPN("-2 3 *"));
        assertEquals(19.0, RPNCalculator.evaluateRPN("3 5 * 4 +"));
        assertEquals(99.0, RPNCalculator.evaluateRPN("3 5 8 * 7 - *"));
    }

    @Test
    public void testInvalidExpression() {
        // Test case: Invalid expression (should throw IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluateRPN("4 +"));

        // Test case: Invalid expression (should throw IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluateRPN("4 + 3"));
    }

    @Test
    public void testEmptyExpression() {
        // Test case: Empty expression (should throw IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluateRPN(""));
    }

    @Test
    public void testNullExpression() {
        // Test case: Null expression (should throw IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluateRPN(null));
    }

    @Test
    public void testInvalidToken() {
        // Test case: Invalid token (should throw IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluateRPN("4 2 $"));
    }

    @Test
    public void testInsufficientOperands() {
        // Test case: Insufficient operands (should throw IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluateRPN("4 +"));
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluateRPN("4 2 + +"));
    }

    @Test
    public void testNegativeNumbers() {
        // Test case: Negative numbers
        assertEquals(-6.0, RPNCalculator.evaluateRPN("-4 2 -"));
        assertEquals(-2.5, RPNCalculator.evaluateRPN("-5 2.5 +"));
    }

}
