package handlers.implementations;

import handlers.BaseHandler;
import org.javatuples.Quartet;
import strategies.CalculationStrategy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class InputHandler implements BaseHandler {
    private static InputHandler inputHandler;
    private final Scanner scanner;
    private final String endLabel;

    private InputHandler(String endLabel) {
        this.scanner = new Scanner(System.in);
        this.endLabel = endLabel;
    }

    public static InputHandler getInstance(String endLabel) {
        if (inputHandler == null) {
            inputHandler = new InputHandler(endLabel);
        }
        return inputHandler;
    }

    @Override
    public Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>>
    process(Quartet<String, BigDecimal, BigDecimal, Map<String, CalculationStrategy>> state) {

        String[] command = scanner.nextLine().split(" ");

        switch (command.length) {
            case 1:
                if (command[0].equals(endLabel)) {
                    state = state.setAt0(command[0]);
                }
                break;
            case 3:
                state = state.setAt0(command[1]);
                state = state.setAt1(new BigDecimal(command[0]));
                state = state.setAt2(new BigDecimal(command[2]));
                break;
            default:
                throw new RuntimeException("wrong number of arguments");
        }

        return state;
    }

}
