import input.InputHandler;
import operations.Division;
import operations.Operation;

import java.util.Map;

public class Calculator {
    public static void main(String[] args) {
        Map<String, Operation> operations = Map.of("div", new Division());

        new InputHandler(args, operations).process();
    }
}
