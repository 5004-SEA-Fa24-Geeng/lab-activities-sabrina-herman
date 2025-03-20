package model;

import java.util.List;

public interface ICalculator {
    Number invokeOperation(Operation operation, Number a, Number b);

    Number add(Number a, Number b);

    Number subtract(Number a, Number b);

    Number multiply(Number a, Number b);

    Number divide(Number a, Number b);

    List<String> getOperationSymbols();

    Operation getOperation(String symbol);
}
