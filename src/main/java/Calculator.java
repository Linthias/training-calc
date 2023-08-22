import handlers.implementations.CalculationHandlerProxy;
import handlers.implementations.InputHandler;
import handlers.implementations.OutputHandler;
import handlers.implementations.ValidationHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

public class Calculator {
    public static void main(String[] args) {

        // введенная команда, [arg1 или result (после вычисления), arg2], команда выхода, набор операций
        Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>
                state = Initializer.initialize();

        while (true) {
            state = LifecycleWrapper.getInstance().performLifecycleStep(state);

            if (state.getValue0().equals(state.getValue2())) {
                break;
            }
        }
    }
}
