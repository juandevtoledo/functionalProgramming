package bestpractice;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.valueOf;

public class DiscountExample {
    private final List<BigDecimal> numbers = List.of(valueOf(10), valueOf(25), valueOf(30), valueOf(1), valueOf(45), valueOf(200));

    private void imperative() {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal number : numbers) {
            if (number.compareTo(valueOf(25)) > 0) {
                sum = sum.add(number.multiply(valueOf(0.8)));
            }
        }
        System.out.println("Total: " + sum);
    }

    private void functional() {
        final BigDecimal sum =
                numbers.stream()
                        .filter(number -> number.compareTo(BigDecimal.valueOf(25)) > 0)
                        .map(number -> number.multiply(BigDecimal.valueOf(0.8)))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total: " + sum);
    }

    public static void main(String... args) {
        new DiscountExample().imperative();
        new DiscountExample().functional();
    }
}
