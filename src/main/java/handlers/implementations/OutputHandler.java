package handlers.implementations;

import handlers.BaseHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;

public class OutputHandler implements BaseHandler {
    private static OutputHandler outputHandler;
    private final String endLabel;

    private OutputHandler(String endLabel) {
        this.endLabel = endLabel;
    }

    public static OutputHandler getInstance(String endLabel) {
        if (outputHandler == null) {
            outputHandler = new OutputHandler(endLabel);
        }
        return outputHandler;
    }

    @Override
    public Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>>
    process(Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>> state) {

        String[] commands = state.getValue0().split(";");

        if (commands[0].equals(endLabel)) {
            for (int i = 1; i < commands.length; i++) {
                System.out.println(commands[i]);
            }
            state = state.setAt0(endLabel);
        } else {
            System.out.println(state.getValue1());
        }

        return state;
    }
}
