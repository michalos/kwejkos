package pl.akademiakodu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.controller.dao.CategoryRepository;
import pl.akademiakodu.controller.dao.GifRepository;
import pl.akademiakodu.controller.model.Category;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    // categoryRepository = new CategoryRepository();

    @Autowired
    private GifRepository gifRepository;


    @RequestMapping("/category/{categoryId}")
    public String category(@PathVariable int categoryId, ModelMap modelMap){
        Category category = categoryRepository.findById(categoryId);
        modelMap.addAttribute("category",category);
        modelMap.addAttribute("gifs",gifRepository.findById(categoryId));
        return "category";
    }


    @GetMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        modelMap.addAttribute("categories",categoryRepository.getAllCategories());
        return "categories";
    }

}
