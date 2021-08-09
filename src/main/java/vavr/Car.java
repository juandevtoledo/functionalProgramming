
package vavr;

public class Car {
    private final int id;
    private final String name;

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Car defaultCar() {
        return new Car(2, "default");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}