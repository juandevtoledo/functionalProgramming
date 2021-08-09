package functionalinterfaz;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

    static void test(Consumer<String> consumer) {
        consumer.accept("hola");
    }

    public static void main(String... args) {
        ConsumerExample.test(s -> System.out.println("hola soy consumenr " + s));
        //Concat Consumer
        Consumer<String> firstConsumer = s -> System.out.println("I am the one " + s);
        firstConsumer.andThen(s -> System.out.println("I am the second " + s))
                .andThen(s -> System.out.println("I am the third " + s))
                .accept(" son ");
        BiConsumer<String,String> biConsumer;


    }
}
