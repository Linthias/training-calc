package handlers.implementations;

import handlers.BaseHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;

public class ValidationHandler implements BaseHandler {
    private static ValidationHandler validationHandler;

    private ValidationHandler() {
    }

    public static ValidationHandler getInstance() {
        if (validationHandler == null) {
            validationHandler = new ValidationHandler();
        }

        return validationHandler;
    }
    @Override
    public Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>
    handle(Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>> state) {

        String command = state.getValue0();
        String endCommand = state.getValue2();
        BigDecimal argTwo = state.getValue1()[1];
        Map<String, CalculationStrategy> strategies = state.getValue3();

        if (!command.equals(endCommand)) {
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
