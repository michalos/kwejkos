package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.akademiakodu.controller.dao.GifRepository;
import pl.akademiakodu.controller.model.Gif;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/")
    public String listGifs(ModelMap modelMap) {
        modelMap.addAttribute("gifs", gifRepository.getAllGifs());
        return "home";
    }

    // localhost:8080/gif/ben-and-mike

    @GetMapping("/favorites")
    public String getFavorites(ModelMap modelMap) {
        modelMap.addAttribute("gifs", gifRepository.getFavorites());
        return "favorites";
    }


    @GetMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.addAttribute("gif", gif);
        return "gif-details";
    }
    
}
