import org.javatuples.Quartet;
import strategies.implementations.AdditionStrategy;
import strategies.CalculationStrategy;
import strategies.implementations.DivisionStrategy;
import strategies.implementations.MultiplicationStrategy;
import strategies.implementations.SubstractionStrategy;

import java.math.BigDecimal;
import java.util.Map;

public class Initializer {

    // введенная команда, [arg1 или result (после вычисления), arg2], команда выхода, набор операций
    static Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>> initialize() {
        String END_COMMAND = "/end";

        return new Quartet<>(null, null, END_COMMAND,
                Map.of(
                "+", new AdditionStrategy(),
                "-", new SubstractionStrategy(),
                "*", new MultiplicationStrategy(),
                "/", new DivisionStrategy()));
    }
}
