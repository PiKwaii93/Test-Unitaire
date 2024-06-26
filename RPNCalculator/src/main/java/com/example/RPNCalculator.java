package RPNCalculator.src.main.java.com.example;

import java.util.*;

public class RPNCalculator {

    private static final Map<String, Operator> operators = new HashMap<>();

    static {
        operators.put("+", new Addition());
        operators.put("-", new Subtraction());
        operators.put("*", new Multiplication());
    }

    public static double evaluateRPN(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression must not be null or empty");
        }

        String[] tokens = expression.split("\\s+");
        Deque<Double> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (operators.containsKey(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Not enough operands for " + token + " operator");
                }
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = operators.get(token).apply(operand1, operand2);
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Invalid token encountered: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression format");
        }

        return stack.pop();
    }

    private static boolean isNumeric(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
