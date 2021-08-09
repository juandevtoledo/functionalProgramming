package vavr;

import io.vavr.control.Try;

public class TryTest {

    public static void main(String... args) {
        Try<Integer> result = Try.of(() -> 1 / 0);
        System.out.println(result.isFailure());
        //
        int div = result
                .onFailure(error -> System.out.println("Error in arithmetic operation " + error.getMessage()))
                .recover(error -> 0)
                .get();
        System.out.println(div);
    }
}
