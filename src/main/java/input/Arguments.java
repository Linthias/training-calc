package input;

import com.beust.jcommander.Parameter;

public class Arguments {
    @Parameter(names = {"-arg1", "-argument1"}, validateWith = NotNullParam.class)
    Double argumentOne;

    @Parameter(names = {"-arg2", "-argument2"}, validateWith = NotNullParam.class)
    Double argumentTwo;

    @Parameter(names = {"-operation", "-op"}, validateWith = NotNullParam.class)
    String operation;
}
