package strategies;

import java.math.BigDecimal;

public interface CalculationStrategy {
    BigDecimal execute(BigDecimal argOne, BigDecimal argTwo);
}
