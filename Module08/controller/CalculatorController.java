package controller;

import model.Calculator;
import model.ICalculator;
import model.Operation;
import view.ConsoleView;

import java.util.Stack;

public class CalculatorController implements IController {

    private ConsoleView view;
    private ICalculator model;


    public CalculatorController(ConsoleView view, ICalculator model) {
        this.view = view;
        this.model = model;
    }

    private Number isNumber(String token) {
        try {
            Number dbl = Double.parseDouble(token);
            return dbl;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public Number processOperation(String operation) {
        Stack<Number> numbers = new Stack<>();

        String[] tokens = operation.split("\\s+");
        for (var i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (token.isEmpty()) {
                continue;
            }
            Number number;
            if ((number = isNumber(token)) != null) {
                numbers.push(number);
            } else {
                Operation op = Operation.getOperation(token);
                if (op == null) {
                    throw new IllegalArgumentException("Invalid operation: " + token);
                }
                if (numbers.size() < 2) {
                    throw new IllegalArgumentException("Not enough numbers for operation: " + token);
                }
                Number b = numbers.pop();
                Number a = numbers.pop();
                Number result;
                switch (op) {
                    case ADD:
                        result = model.add(a, b);
                        break;
                    case SUBTRACT:
                        result = model.subtract(a, b);
                        break;
                    case MULTIPLY:
                        result = model.multiply(a, b);
                        break;
                    case DIVIDE:
                        result = model.divide(a, b);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation: " + token);
                }
                numbers.push(result);
            }
        }
        if (numbers.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        return numbers.pop();
    }
}
