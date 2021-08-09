package highorderfunction;

import java.util.Comparator;
import java.util.List;

public class HighOrderFunctionExample {
    private final List<String> names = List.of("Rebeca", "Andres", "Pepe", "Nicolas");

    public void orderBy(Comparator<String> comparator) {
        names.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    public static void main(String... args) {
        HighOrderFunctionExample highOrderFunctionExample = new HighOrderFunctionExample();
        highOrderFunctionExample.orderBy(String::compareTo);
        System.out.println(" -- ");
        highOrderFunctionExample.orderBy(Comparator.reverseOrder());
    }
}
