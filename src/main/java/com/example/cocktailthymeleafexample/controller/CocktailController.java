package com.example.cocktailthymeleafexample.controller;
import com.example.cocktailthymeleafexample.model.Cocktail;
import com.example.cocktailthymeleafexample.service.CocktailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("cocktails")
public class CocktailController {
    CocktailService cocktailService;

    public CocktailController(CocktailService cocktailService){
        this.cocktailService = cocktailService;
    }

    @GetMapping("")
    public String showAll(@RequestParam(required = false) String ingredient, Model model){
        List<Cocktail> cocktailList;
        if (ingredient != null && !ingredient.isEmpty()){
            cocktailList = cocktailService.findWithIngredient(ingredient);
            model.addAttribute("ingredient", ingredient);
        }
        else {
            cocktailList = cocktailService.findAll();
        }
        model.addAttribute("cocktails", cocktailList);
        return "cocktails";
    }

    @GetMapping("/{name}")
    public String findCocktailByName(@PathVariable("name") String name, Model model){
        Cocktail cocktail = cocktailService.findByName(name);
        model.addAttribute("name", cocktail.getName());
        model.addAttribute("ingredients", cocktail.getIngredients());
        return "cocktailDetails";
    }


}
