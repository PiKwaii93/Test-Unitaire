package RPNCalculator.src.main.java.com.example;

public class Addition implements Operator {
    @Override
    public double apply(double operand1, double operand2) {
        return operand1 + operand2;
    }
}
