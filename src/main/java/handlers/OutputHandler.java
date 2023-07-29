package handlers;

public class OutputHandler {
    private final double result;

    public OutputHandler(double result) {
        this.result = result;
    }

    public void process() {
        System.out.println(result);
    }
}
