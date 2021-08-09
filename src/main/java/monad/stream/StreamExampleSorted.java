package monad.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamExampleSorted {

    private List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1","a3","b2");

    private void sorted_Stream() {
        myList.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

    private void sorted_Imperative() {
        Collections.sort(myList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String s : myList) {
            System.out.println(s);
        }
    }

    public static void main(String... args) {
        StreamExampleSorted sorted = new StreamExampleSorted();
        sorted.sorted_Stream();
        System.out.println( " .... ");
        sorted.sorted_Imperative();
    }
}
