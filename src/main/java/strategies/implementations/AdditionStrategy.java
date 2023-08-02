package strategies.implementations;

import strategies.CalculationStrategy;

import java.math.BigDecimal;

public class AdditionStrategy implements CalculationStrategy {
    @Override
    public BigDecimal execute(BigDecimal argOne, BigDecimal argTwo) {
        return argOne.add(argTwo);
    }
}
