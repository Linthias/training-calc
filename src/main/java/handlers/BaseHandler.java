package handlers;

import org.javatuples.Quartet;
import org.javatuples.Triplet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;

public interface BaseHandler {
    Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>
    handle(Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>> state);
}
