package monad.stream;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {

    private static <T> List<T> createList(Function<Integer, T> newObj) {
        return IntStream
                .range(1, 10)
                .mapToObj(newObj::apply)
                .collect(Collectors.toList());
    }

    public static void main(String... args) {
        createList(i -> new String(" Seq. process " + i))
                .stream()
                .forEach(System.out::println);
        //
        System.out.println(" -- ");
        createList(i -> new String(" Parallel process " + i))
                .parallelStream()
                .forEach(System.out::println);
    }
}
