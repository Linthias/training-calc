import org.javatuples.Quartet;
import strategies.implementations.AdditionStrategy;
import strategies.CalculationStrategy;
import strategies.implementations.DivisionStrategy;
import strategies.implementations.MultiplicationStrategy;
import strategies.implementations.SubstractionStrategy;

import java.math.BigDecimal;
import java.util.Map;

public class Initializer {

    static Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>> initialize() {

        return new Quartet<>(null, null, null,
                Map.of(
                "+", new AdditionStrategy(),
                "-", new SubstractionStrategy(),
                "*", new MultiplicationStrategy(),
                "/", new DivisionStrategy()));
    }
}
