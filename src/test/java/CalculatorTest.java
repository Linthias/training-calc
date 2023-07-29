import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CalculatorTest {

    @Test
    public void test() {
        String[] args = {"-arg1", "34", "-arg2", "2", "-operation", "div"};

        assertDoesNotThrow(() -> Calculator.main(args));
    }
}
