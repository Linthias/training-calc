package handlers.implementations;

import handlers.BaseHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;

public class CalculationHandlerProxy implements BaseHandler {
    private static CalculationHandlerProxy calculationHandlerProxy;
    private final StringBuilder operationLog;
    private final String endLabel;

    private CalculationHandlerProxy(String endLabel) {
        this.operationLog = new StringBuilder("");
        this.endLabel = endLabel;
    }

    public static CalculationHandlerProxy getInstance(String endLabel) {
        if (calculationHandlerProxy == null) {
            calculationHandlerProxy = new CalculationHandlerProxy(endLabel);
        }
        return calculationHandlerProxy;
    }
    @Override
    public Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>>
    process(Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>> state) {

        String opLabel = state.getValue0();
        BigDecimal argOne = state.getValue1();
        BigDecimal argTwo = state.getValue2();

        if (opLabel.equals(endLabel)) {
            state = state.setAt0(endLabel + ";" + operationLog);
        } else {
            state = CalculationHandler.getInstance().process(state);
            operationLog.append(argOne + opLabel + argTwo + "=" + state.getValue1() + ";");
        }

        return state;
    }
}
