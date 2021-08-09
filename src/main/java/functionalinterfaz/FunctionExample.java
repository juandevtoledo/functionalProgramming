package functionalinterfaz;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

    static void test(Function<String, Long> function) {

        System.out.println(" Resulted " + function.apply("value"));
    }

    public static void main(String... args) {
        //
        FunctionExample.test(s -> Long.valueOf(s.length()));
        FunctionExample.test(s ->
                Arrays.stream(s.split(""))
                        .filter(letter -> letter.equals("a")).count());
        //
        Function<String, Integer> number = s -> s.length();
        Integer result = number.andThen((var val) -> val + 10).apply("demo_functional");
        System.out.println(" Result "+result);

        // BIFUNCTION
        // takes two Integers and return an Integer
        BiFunction<Integer, Integer, Integer> biFunc = (x1, x2) -> x1 + x2;
        System.out.println(biFunc.apply(1,2));
    }
}
