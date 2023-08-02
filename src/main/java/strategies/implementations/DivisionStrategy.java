package strategies.implementations;

import strategies.CalculationStrategy;

import java.math.BigDecimal;

public class DivisionStrategy implements CalculationStrategy {
    @Override
    public BigDecimal execute(BigDecimal argOne, BigDecimal argTwo) {
        return argOne.divide(argTwo);
    }
}
