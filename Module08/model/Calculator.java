package model;

import java.util.List;

public class Calculator implements ICalculator {


    @Override
    public Number invokeOperation(Operation operation, Number a, Number b) {
        return null;
    }

    public Number add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    public Number subtract(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    public Number multiply(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    public Number divide(Number a, Number b) {
        return a.doubleValue() / b.doubleValue();
    }

    @Override
    public List<String> getOperationSymbols() {
        return List.of();
    }

    @Override
    public Operation getOperation(String symbol) {
        return null;
    }
}
