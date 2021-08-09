package vavr;

import io.vavr.control.Option;

import static vavr.Car.defaultCar;

public class OptionTest {
    private Option<Car> findCarById(final String name) {
        return Option.none();
    }

    private void find() {
        findCarById("T 543 KK")
                .filter(car -> car.getId() == 1)
                .getOrElse(defaultCar());
    }

    private void toMonad() {
        findCarById("T 543 KK")
                .toTry()
                .onFailure(System.out::println)
                .onSuccess(System.out::println);
    }

    public static void main(String... args) {
        new OptionTest().find();
        new OptionTest().toMonad();
    }

}


