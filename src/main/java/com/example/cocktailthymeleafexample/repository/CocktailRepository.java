package com.example.cocktailthymeleafexample.repository;

import com.example.cocktailthymeleafexample.model.Cocktail;
import com.example.cocktailthymeleafexample.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CocktailRepository {

    private List<Cocktail> cocktailList;

    public CocktailRepository(){
        createCocktailList();
    }


    public void createCocktailList(){
        cocktailList = List.of(
                new Cocktail("Long Island Ice Tea", List.of(
                        new Ingredient("Vodka"),
                        new Ingredient("Rom"),
                        new Ingredient("Gin"),
                        new Ingredient("Contreau"),
                        new Ingredient("Lemon juice"),
                        new Ingredient("Sugar Sirup"),
                        new Ingredient("Cola"))),

                new Cocktail("Rom & Cola", List.of(
                        new Ingredient("Rom"),
                        new Ingredient("Cola"))),

                new Cocktail("Gin & Tonic", List.of(
                        new Ingredient("Gin"),
                        new Ingredient("Tonic"))));
    }

    public List<Cocktail> findAll(){
        return cocktailList;
    }

    public Cocktail findByName(String name) {
        Cocktail returnCocktail = null;
        for (Cocktail cocktail: cocktailList){
            if (cocktail.getName().equalsIgnoreCase(name)){
                returnCocktail = cocktail;
            }
        }
        return returnCocktail;
    }

    public List<Cocktail> findWithIngredient(String ingredient) {
        List<Cocktail> cocktailList1 = new ArrayList<>();
        for(Cocktail cocktail: cocktailList){
            for (Ingredient ing : cocktail.getIngredients()){
                if (ing.getName().contains(ingredient)){
                    cocktailList1.add(cocktail);
                }
            }
        }
        return cocktailList1;
    }
    
}
