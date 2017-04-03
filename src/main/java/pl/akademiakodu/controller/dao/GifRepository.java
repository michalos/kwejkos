package pl.akademiakodu.controller.dao;


import org.springframework.stereotype.Component;
import pl.akademiakodu.controller.model.Gif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "Crhis Nowak", false, 1),
            new Gif("ben-and-mike", "Ben Jakuben", true, 1),
            new Gif("book-dominos", "Craig Dennis", false, 2),
            new Gif("cowboy-coder", "Grace Hoper", false, 2),
            new Gif("infinite-andrew", "Marissa Mayer", true, 3)
    );

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> getFavorites() {
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.isFavorite())
                gifs.add(gif);
        }
        return gifs;
    }

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> findById(Integer id) {
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.getCategoryId() == id)
                gifs.add(gif);
        }
        return gifs;
    }

}
