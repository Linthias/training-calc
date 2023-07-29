package operations;

public class Division implements Operation {
    @Override
    public double perform(double argOne, double argTwo) {
        double result;

        if (validArgument(argTwo)) {
            result = argOne / argTwo;
        } else {
            throw new RuntimeException("not valid arguments");
        }

        return result;
    }

    private boolean validArgument(double argTwo) {
        boolean result = false;

        if (argTwo != 0) {
            result = true;
        }

        return result;
    }
}
