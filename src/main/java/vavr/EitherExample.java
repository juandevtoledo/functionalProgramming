package vavr;

import io.vavr.control.Either;
import io.vavr.control.Try;

public class EitherExample {

    public static void main(String... args) {
        Either<String, Integer> divOperEither = getMap(1, 1);
        divOperEither
                .peekLeft(error -> System.out.println("Error in arithmetic operation "))
                .peek(success -> System.out.println("success div"))
                .mapLeft(error -> new String("success"))
                .map(div -> div + 1);
        System.out.println(" -> " + divOperEither.fold(error -> 0, success -> success));
    }

    private static Either<String, Integer> getMap(int num1, int num2) {
        return Try.of(() -> num1 / num2)
                .toEither("Error div");
    }
}
