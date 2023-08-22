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

    private InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public static InputHandler getInstance() {
        if (inputHandler == null) {
            inputHandler = new InputHandler();
        }

        return inputHandler;
    }

    @Override
    public Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>>
    handle(Quartet<String, BigDecimal[], String, Map<String, CalculationStrategy>> state) {

        String[] command = scanner.nextLine().split(" ");
        String endCommand = state.getValue2();

        switch (command.length) {
            case 1:
                if (command[0].equals(endCommand)) {
                    state = state.setAt0(command[0]);
                } else {
                    throw new RuntimeException("wrong operation; expected to be: /end");
                }
                break;
            case 3:
                state = state.setAt0(command[1]);

                BigDecimal[] arguments = {new BigDecimal(command[0]), new BigDecimal(command[2])};
                state = state.setAt1(arguments);
                break;
            default:
                throw new RuntimeException("wrong number of arguments");
        }

        return state;
    }

}
