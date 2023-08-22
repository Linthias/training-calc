package handlers.implementations;

import handlers.BaseHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;

public class OutputHandler implements BaseHandler {
    private static OutputHandler outputHandler;
    private final static String SEMICOLON_DELIMITER = ";";

    private OutputHandler() {
    }

    public static OutputHandler getInstance() {
        if (outputHandler == null) {
            outputHandler = new OutputHandler();
        }

        return outputHandler;
    }

    @Override
    public Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>
    handle(Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>> state) {

        String[] commands = state.getValue0().split(SEMICOLON_DELIMITER);
        String endCommand = state.getValue2();

        // если в начале есть команда выхода,
        // то в этот момент в массиве также хранится и вся история запросов
        if (commands[0].equals(endCommand)) {
            for (int i = 1; i < commands.length; i++) {
                System.out.println(commands[i]);
            }
            // после печати истории,
            // надо передать команду на выход в основной цикл
            state = state.setAt0(endCommand);
        } else {
            System.out.println(state.getValue1()[0]);
        }

        return state;
    }
}
