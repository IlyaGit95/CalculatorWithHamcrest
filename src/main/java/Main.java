import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);

        calc.println.accept(c);
        // Причина ошибки:
        // Выбрасывыется исключение ArithmeticException так как мы выполняем деление на 0
        // Способ решения ошибки с помощью обработки исключений:
        // BinaryOperator<Integer> devide = (x, y) -> {
        //    try {
        //        return x / y;
        //    } catch (ArithmeticException e) {
        //        System.out.print("Нельзя делить на ");
        //       return 0;
        //   }
        // };
    }
}
