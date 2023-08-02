package handlers.implementations;

import handlers.BaseHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;

public class ValidationHandler implements BaseHandler {
    private static ValidationHandler validationHandler;
    private final String endLabel;

    private ValidationHandler(String endLabel) {
        this.endLabel = endLabel;
    }

    public static ValidationHandler getInstance(String endLabel) {
        if (validationHandler == null) {
            validationHandler = new ValidationHandler(endLabel);
        }
        return validationHandler;
    }
    @Override
    public Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>>
    process(Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>> state) {

        String command = state.getValue0();
        BigDecimal argTwo = state.getValue2();
        Map<String, CalculationStrategy> strategies = state.getValue3();

        if (!command.equals(endLabel)) {
            if (strategies.containsKey(command)) {
                if (command.equals("/")) {
                    if (argTwo.doubleValue() == 0) {
                        throw new RuntimeException("invalid argument for division");
                    }
                }
            } else {
                throw new RuntimeException("nonexistent operation");
            }
        }

        return state;
    }
}
