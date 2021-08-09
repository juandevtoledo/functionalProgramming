package highorderfunction;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateListHighOrderFunction {
    private static <T> List<T> createList(Function<Integer, T> newObj) {
        return IntStream
                .range(1, 10)
                .mapToObj(newObj::apply)
                .collect(Collectors.toList());
    }

    public static void main(String... args) {
        System.out.println("List Integer");
        //Crear lista de Strings
        createList(integer -> String.valueOf(integer).concat(" val"))
                .forEach(System.out::println);
        System.out.println("List BigDecimal");
        //Crear lista de BigDecimal
        createList(BigDecimal::valueOf)
                .forEach(System.out::println);
        System.out.println("List Objects");
        //Crear lista de Objects
        createList(Demo::new)
                .forEach(System.out::println);

    }

    static class Demo {
        private int id;
        private String name;

        public Demo(int id) {
            this.id = id;
            this.name = "Demo :" + id;
        }

        @Override
        public String toString() {
            return "Demo{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
