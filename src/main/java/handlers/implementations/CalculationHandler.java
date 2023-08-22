package handlers.implementations;

import handlers.BaseHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;

public class CalculationHandler implements BaseHandler {
    private static  CalculationHandler calculationHandler;
    private CalculationHandler() {

    }

    public static CalculationHandler getInstance() {
        if (calculationHandler == null) {
            calculationHandler = new CalculationHandler();
        }

        return calculationHandler;
    }

    @Override
    public Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>
    handle(Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>> state) {

        String opLabel = state.getValue0();
        BigDecimal argOne = state.getValue1()[0];
        BigDecimal argTwo = state.getValue1()[1];
        Map<String, CalculationStrategy> strategies = state.getValue3();

        BigDecimal[] result = {strategies.get(opLabel).execute(argOne, argTwo), argTwo};
        state = state.setAt1(result);

        return state;
    }

}
