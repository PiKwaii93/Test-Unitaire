package RPNCalculator.src.main.java.com.example;

import java.util.*;

public class RPNCalculator {

    public static double evaluateRPN(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression must not be null or empty");
        }
        
        // Split the expression into tokens
        String[] tokens = expression.split("\\s+");
        
        // Stack to store operands
        Deque<Double> stack = new ArrayDeque<>();
        
        // Operators set
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/", "SQRT", "MAX"));
        
        // Process each token
        for (String token : tokens) {
            if (!operators.contains(token)) {
                // Token is a number, push it onto the stack
                try {
                    double number = Double.parseDouble(token);
                    stack.push(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid token encountered: " + token);
                }
            } else {
                // Token is an operator, perform the operation
                switch (token) {
                    case "+":
                        if (stack.size() < 2) {
                            throw new IllegalArgumentException("Not enough operands for + operator");
                        }
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        if (stack.size() < 2) {
                            throw new IllegalArgumentException("Not enough operands for - operator");
                        }
                        double subtrahend = stack.pop();
                        double minuend = stack.pop();
                        stack.push(minuend - subtrahend);
                        break;
                    case "*":
                        if (stack.size() < 2) {
                            throw new IllegalArgumentException("Not enough operands for * operator");
                        }
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        if (stack.size() < 2) {
                            throw new IllegalArgumentException("Not enough operands for / operator");
                        }
                        double divisor = stack.pop();
                        double dividend = stack.pop();
                        stack.push(dividend / divisor);
                        break;
                    case "SQRT":
                        if (stack.isEmpty()) {
                            throw new IllegalArgumentException("Not enough operands for SQRT operator");
                        }
                        stack.push(Math.sqrt(stack.pop()));
                        break;
                    case "MAX":
                        if (stack.size() < 2) {
                            throw new IllegalArgumentException("Not enough operands for MAX operator");
                        }
                        double maxOperand2 = stack.pop();
                        double maxOperand1 = stack.pop();
                        stack.push(Math.max(maxOperand1, maxOperand2));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator: " + token);
                }
            }
        }
        
        // At the end, there should be exactly one element in the stack, which is the result
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression format");
        }
        
        return stack.pop();
    }
    
}
