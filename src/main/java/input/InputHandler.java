package input;

import com.beust.jcommander.JCommander;
import handlers.CalculationHandler;
import operations.Operation;

import java.util.Map;

public class InputHandler {
    private final String[] input;
    private final Arguments args;
    private final Map<String, Operation> operations;

    public InputHandler(String[] input, Map<String, Operation> operations) {
        this.input = input;
        this.args = new Arguments();
        this.operations = operations;
    }

    public void process() {
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(input);

        new CalculationHandler(
                args.argumentOne,
                args.argumentTwo,
                args.operation,
                operations)
                .process();
    }

}
