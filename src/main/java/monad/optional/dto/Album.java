package monad.optional.dto;

public class Album {
    private final int id;
    private final String name;

    public Album(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Album empty() {
        return new Album(2, "Empty");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}