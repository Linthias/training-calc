package strategies.implementations;

import strategies.CalculationStrategy;

import java.math.BigDecimal;

public class SubstractionStrategy implements CalculationStrategy {
    @Override
    public BigDecimal execute(BigDecimal argOne, BigDecimal argTwo) {
        return argOne.subtract(argTwo);
    }
}
