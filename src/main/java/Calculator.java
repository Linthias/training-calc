import handlers.implementations.CalculationHandlerProxy;
import handlers.implementations.InputHandler;
import handlers.implementations.OutputHandler;
import handlers.implementations.ValidationHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;

public class Calculator {
    public static void main(String[] args) {

        Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>>
                state = Initializer.initialize();

        String END_LABEL = "/end";

        while(true) {
            state = OutputHandler.getInstance(END_LABEL).process(
                    CalculationHandlerProxy.getInstance(END_LABEL).process(
                            ValidationHandler.getInstance(END_LABEL).process(
                                    InputHandler.getInstance(END_LABEL).process(state))));

            if (state.getValue0().equals(END_LABEL)) {
                break;
            }
        }
    }
}
