package pl.akademiakodu.controller.dao;


import org.springframework.stereotype.Component;
import pl.akademiakodu.controller.model.Gif;

import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "Crhis Nowak", false),
            new Gif("ben-and-mike", "Ben Jakuben", true),
            new Gif("book-dominos", "Craig Dennis", false),
            new Gif("cowboy-coder", "Grace Hoper", false),
            new Gif("infinite-andrew", "Marissa Mayer", true)
    );

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

}
