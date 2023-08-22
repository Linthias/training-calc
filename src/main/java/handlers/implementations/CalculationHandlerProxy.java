package handlers.implementations;

import handlers.BaseHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;

public class CalculationHandlerProxy implements BaseHandler {
    private static CalculationHandlerProxy calculationHandlerProxy;
    private final StringBuilder operationLog;
    private final static String SEMICOLON_DELIMITER = ";";
    private final static String EQUAL_DELIMITER = "=";

    private CalculationHandlerProxy() {
        this.operationLog = new StringBuilder();
    }

    public static CalculationHandlerProxy getInstance() {
        if (calculationHandlerProxy == null) {
            calculationHandlerProxy = new CalculationHandlerProxy();
        }

        return calculationHandlerProxy;
    }
    @Override
    public Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>
    handle(Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>> state) {

        String opLabel = state.getValue0();
        String endCommand = state.getValue2();
        BigDecimal argOne = state.getValue1()[0];
        BigDecimal argTwo = state.getValue1()[1];

        // если пришла команда выхода,
        // то в первый параметр вместе с ней записывается и история запросов
        if (opLabel.equals(endCommand)) {
            state = state.setAt0(endCommand + SEMICOLON_DELIMITER + operationLog);
        } else {
            state = CalculationHandler.getInstance().handle(state);
            operationLog.append(argOne + opLabel + argTwo +
                    EQUAL_DELIMITER + state.getValue1()[0] + SEMICOLON_DELIMITER);
        }

        return state;
    }
}
