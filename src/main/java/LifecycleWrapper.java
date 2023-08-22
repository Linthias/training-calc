import handlers.implementations.CalculationHandlerProxy;
import handlers.implementations.InputHandler;
import handlers.implementations.OutputHandler;
import handlers.implementations.ValidationHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

public class LifecycleWrapper {
    private static LifecycleWrapper lifecycleWrapper;

    private LifecycleWrapper() {

    }

    public static LifecycleWrapper getInstance() {
        if (lifecycleWrapper == null) {
            lifecycleWrapper = new LifecycleWrapper();
        }

        return lifecycleWrapper;
    }

    private final Function<Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>,
            Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>>
            handleInput = state -> InputHandler.getInstance().handle(state);

    private final Function<Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>,
            Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>>
            handleValidation = state -> ValidationHandler.getInstance().handle(state);

    private final Function<Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>,
            Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>>
            handleCalculation = state -> CalculationHandlerProxy.getInstance().handle(state);

    private final Function<Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>,
            Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>>
            handleOutput = state -> OutputHandler.getInstance().handle(state);

    private final Function<Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>,
            Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>>
            pipeline = handleInput.andThen(handleValidation).andThen(handleCalculation).andThen(handleOutput);

    Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>
    performLifecycleStep(Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>> state) {
        return pipeline.apply(state);
    }
}
