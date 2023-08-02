package handlers;

import org.javatuples.Quartet;
import org.javatuples.Triplet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;

public interface BaseHandler {
    Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>>
    process(Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>> state);
}
