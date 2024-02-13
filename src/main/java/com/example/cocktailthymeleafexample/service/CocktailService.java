package com.example.cocktailthymeleafexample.service;

import com.example.cocktailthymeleafexample.model.Cocktail;
import com.example.cocktailthymeleafexample.repository.CocktailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocktailService {
    private CocktailRepository cocktailRepository;

    public CocktailService (CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }

    public List<Cocktail> findAll(){
        return cocktailRepository.findAll();
    }


    public Cocktail findByName(String name) {
        return cocktailRepository.findByName(name);
    }

    public List<Cocktail> findWithIngredient(String ingredient) {
        return cocktailRepository.findWithIngredient(ingredient);
    }
}
