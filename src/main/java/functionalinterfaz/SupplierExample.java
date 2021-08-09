package functionalinterfaz;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierExample
{
    static void test(Supplier<Integer> supplier){
        System.out.println( " Equal ->"+ supplier.get());
    }

    public static void main(String... args){
        SupplierExample.test(()->10*50+10+1);
        //Example Generate
        Stream.generate(()->new Random().nextInt())
                .limit(5)
                .forEach(System.out::println);

    }
}
