import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

    // Задача 2
    @Test
    public void plusTestHamcrest() {
        int x = 5;
        int y = 10;
        int expended = 15;

        int result = calculator.plus.apply(x, y);

        assertThat(result, equalTo(expended));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void isPositiveTest(int argument) {
        Assertions.assertTrue(calculator.isPositive.test(argument));
    }

    // Задача 2
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void isPositiveTestHamcrest(int argument) {
        boolean result = calculator.isPositive.test(argument);
        assertThat(result, is(true));
    }

    @Test
    public void devideTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.devide.apply(1, 0));
    }

    //задача 2
    @Test
    public void devideTestHamcrest() {
        double result = calculator.devide.apply(10, 2);
        assertThat(result, closeTo(5, 0.0001));
    }

    //задача 2
    @Test
    public void instanceTestHamcrest() {
        Calculator calcul = Calculator.instance.get();
        assertThat(calcul, notNullValue());
    }

    //задача 2
    @Test
    public void powTestHamcrest() {
        int result = calculator.pow.apply(5);
        assertThat(result, allOf(greaterThan(0), lessThanOrEqualTo(25), not(equalTo(5))));
    }

}