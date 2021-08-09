package bestpractice;

import java.util.Random;
import java.util.stream.Stream;

public class EvenNumberOldFunctionalApproach
{
    public static void main(String... args){
        Random random = new Random();
        Stream.generate(() -> random.nextInt(100))
                .limit(10)
                .filter(s -> s % 2 == 0)
                .forEach(System.out::println);
    }
}
