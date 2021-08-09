package monad.stream;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    private List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

    private void printJustCLetters_Stream() {
        myList.stream()
                .filter(letter -> letter.startsWith("c"))
                .forEach(System.out::println);
    }

    private void printJustCLetters_Imperative() {
        for (String letter : myList) {
            if (letter.startsWith("c")) {
                System.out.println(letter);
            }
        }
    }

    public static void main(String... args) {
        StreamExample streamExample1 = new StreamExample();
        streamExample1.printJustCLetters_Stream();
        System.out.println(" ..  ");
        streamExample1.printJustCLetters_Imperative();
    }
}
