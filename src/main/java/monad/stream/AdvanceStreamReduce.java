package monad.stream;

import monad.stream.dto.Person;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdvanceStreamReduce {

    private static <T> List<T> createList(Function<Integer, T> newObj) {
        return IntStream
                .range(1, 10)
                .mapToObj(newObj::apply)
                .collect(Collectors.toList());
    }

    //Sumar las edades de los mayores de 60
    public void sum_StreamWay(List<Person> people) {
        Integer ages = people
                .stream()
                .filter(person -> person.getAge() > 60)
                .reduce(0, (sum, p) -> sum += p.getAge(), Integer::sum);
        System.out.println("Ages " + ages);
    }

    public void sum_ImperativeWay(List<Person> people) {
        Integer ages = 0;
        for (Person person : people) {
            if (person.getAge() > 60) {
                ages += person.getAge();
            }
        }
        System.out.println("Ages " + ages);
    }

    public static void main(String... args) {
        List<Person> people = createList(p -> new Person("name : " + p, new Random().nextInt(100)));
        people.forEach(System.out::println);
        AdvanceStreamReduce advance = new AdvanceStreamReduce();
        advance.sum_StreamWay(people);
        System.out.println(" ---   ");
        advance.sum_ImperativeWay(people);
    }
}
