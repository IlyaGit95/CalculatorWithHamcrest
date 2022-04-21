import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    private final Calculator calculator = Calculator.instance.get();

    @Test
    public void plusTest() {
        int x = 5;
        int y = 10;
        int expended = 15;

        int result = calculator.plus.apply(x, y);

        Assertions.assertEquals(expended, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void isPositiveTest(int argument) {
        Assertions.assertTrue(calculator.isPositive.test(argument));
    }

    @Test
    public void devideTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.devide.apply(1, 0));
    }
}