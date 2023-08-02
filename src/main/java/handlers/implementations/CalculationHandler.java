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
    public Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>>
    process(Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>> state) {
        String opLabel = state.getValue0();
        BigDecimal argOne = state.getValue1();
        BigDecimal argTwo = state.getValue2();
        Map<String, CalculationStrategy> strategies = state.getValue3();

        state = state.setAt1(strategies.get(opLabel).execute(argOne, argTwo));

        return state;
    }

}
