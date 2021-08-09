package monad.optional;

import monad.optional.dto.Album;

import java.util.Optional;


public class OptionTest {

    public static void main(String... args) {
        callableOperation();
        notNullPattern();
        optionalImperative();
    }

    private static void callableOperation() {
        Album album = new Album(1, "album");
        Optional.ofNullable(album)
                .ifPresentOrElse(al -> System.out.println("Persist al"), () -> System.out.println("Album emptyø"));
    }

    private static void notNullPattern() {
        Album album = null;
        Album notNullAlbum = Optional.ofNullable(album)
                .orElse(Album.empty());
        System.out.println(notNullAlbum.getId());
    }

    private static Album optionalImperative() {
        Optional<Album> albumOptional = Optional.of(new Album(1, "album"));
        if (albumOptional.isPresent()) {
            return albumOptional.get();
        } else {
            throw new NullPointerException("");
        }
    }

}


