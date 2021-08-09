package functionalinterfaz;


@FunctionalInterface
interface IStrategy{

    void sayHello();
}


public class DemoFunctionalInterfaz
{
    public static void play(IStrategy strategy){
        strategy.sayHello();
    }
    public static void main(String... args){
        //Approach Current Way
        IStrategy strategyCurrently = new IStrategy() {
            @Override
            public void sayHello() {
                System.out.println("******   I am too old *******");
            }
        };
        strategyCurrently.sayHello();

        //Approach Functional Programming
        IStrategy strategy = () -> System.out.println("******  Say Hello *******");
        strategy.sayHello();
        //
        play(()-> System.out.println("****   high order function ***"));

    }
}

