package functionalinterfaz;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    static void test(Predicate<String> predicate) {
        System.out.println(" Equal ->" + predicate.test("juan"));
    }

    static void test(BiPredicate<String, String> biPredicate) {
        System.out.println(" Equal ->" + biPredicate.test("String1", "String2"));
    }

    public static void main(String... args) {
        //Example 1
        PredicateExample.test(s -> s.length() == 4);
        //Example 2
        PredicateExample.test((s, a) -> !s.equals(a));
        //Concat
        Predicate<String> predicate = s -> s.length() == 10;
        boolean result = predicate.and(s -> s.contains("a"))
                .and(s -> !s.isBlank())
                .test("s");
        System.out.println(result);
        //List
        List.of("a", "b", "c")
                .stream()
                .filter("a"::equals)
                .forEach(System.out::println);


    }
}
