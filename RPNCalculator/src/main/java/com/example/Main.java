package RPNCalculator.src.main.java.com.example;

public class Main {

    public static void main(String[] args) {
        // Example usage:
        String expression1 = "4 2 *";
        String expression2 = "4 2 + 3 -";
        String expression3 = "3 5 8 * 7 + *";
        String expression4 = "4 2 -";
        String expression5 = "3 5 8 * 7 - *";
        
        // Evaluate expressions using RPNCalculator and print results
        System.out.println(expression1 + " = " + RPNCalculator.evaluateRPN(expression1));
        System.out.println(expression2 + " = " + RPNCalculator.evaluateRPN(expression2));
        System.out.println(expression3 + " = " + RPNCalculator.evaluateRPN(expression3));
        System.out.println(expression4 + " = " + RPNCalculator.evaluateRPN(expression4));
        System.out.println(expression5 + " = " + RPNCalculator.evaluateRPN(expression5));
    }
}