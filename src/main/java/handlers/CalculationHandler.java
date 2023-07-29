package handlers;

import operations.Operation;

import java.util.Map;

public class CalculationHandler {
    private final Map<String, Operation> operations;
    private final double argOne;
    private final double argTwo;
    private final String opLabel;

    public CalculationHandler(double argOne, double argTwo, String opLabel, Map<String, Operation> operations) {
        this.argOne = argOne;
        this.argTwo = argTwo;
        this.opLabel = opLabel;
        this.operations = operations;
    }

    public void process() {
        double result;

        if (operations.containsKey(opLabel)) {
            result = operations.get(opLabel).perform(argOne, argTwo);
        } else {
            throw new RuntimeException("not supported operation");
        }

        new OutputHandler(result).process();
    }

}
