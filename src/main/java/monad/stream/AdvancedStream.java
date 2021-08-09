package monad.stream;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdvancedStream {


    private static <T> List<T> createList(Function<Integer, T> newObj) {
        return IntStream
                .range(1, 4)
                .mapToObj(newObj::apply)
                .collect(Collectors.toList());
    }

    private static void flapMap() {

        List<Foo> foos = createList((f) -> new Foo("Foo" + f))
                .stream()
                .peek(foo -> foo.setBars(createList(b -> new Bar("new bar " + b + " <- " + foo.name))))
                .collect(Collectors.toList());

        foos.stream()
                .flatMap(f -> f.getBars().stream())
                .forEach(s -> System.out.println(s.name));


    }


    public static void main(String... args) {
        flapMap();
    }
}

class Foo {
    String name;
    private List<Bar> bars;

    Foo(String name) {
        this.name = name;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public List<Bar> getBars() {
        return bars;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}

