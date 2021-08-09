package functionalinterfaz;

import java.util.Locale;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    public static void main(String... args) {

        UnaryOperator<Integer> funcU = x -> x * 2;
        System.out.println(funcU.apply(2));

        // BinaryOperator
        BinaryOperator<Integer> funcB = (x1, x2) -> x1 + x2;
        System.out.println(funcB.apply(2, 3)); // 5
        //
        System.out.println( new testIF().apply("_toledo") );
        UnaryOperator<String> fun2 = s->"juan__ ".concat(s);
        System.out.println(fun2.apply("_toledo"));

    }

    static class testIF implements UnaryOperator<String>{

        @Override
        public String apply(String s) {
            return "juan"+s;
        }
    }
}
