package referencedmethod;

import java.util.Arrays;

public class Methods {
    public static void sayStaticHello() {
        System.out.println("Hey!!! i'am a static hello!");
    }

    public void sayInstanceHello() {
        System.out.println("Hey!!! i'am a instance hello");
    }

    public static void main(String[] args) {
        //Referencia a un método estatico
        IHello staticRef = Methods::sayStaticHello;
        IHello vs = Methods::sayStaticHello;

        staticRef.sayHello();
        ///P
        IHello lambda = Methods::sayStaticHello;

        //Referencia a un método de un objeto
        Methods methods = new Methods();
        IHello instanceRef = methods::sayInstanceHello;
        instanceRef.sayHello();
        //
        IHello lambda2 = methods::sayInstanceHello;

        //Referencia a un método de un objeto arbitrario
        String[] names = new String[]{"Oscar", "Alex", "Maria", "Samuel", "Perla", "Fausto"};
        Arrays.sort(names, String::compareToIgnoreCase);
        //Lambda
        Arrays.sort(names,(o,a)->o.compareToIgnoreCase(a));
        System.out.println("Hey!!! i'am a ordered array " + Arrays.toString(names));

        //Referencia a un constructor
        IHello hello = Hello::new;
        hello.sayHello();

        //Examples List
        Arrays.asList("a","b").forEach(System.out::println);
    }
}

class Hello implements IHello {

    @Override
    public void sayHello() {
        System.out.println("Hey!!! i'am a constructor");
    }
}
