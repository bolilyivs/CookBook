package com.bolilyivs.cookbook.Controller;

import com.bolilyivs.cookbook.Entity.Ingredient;
import com.bolilyivs.cookbook.Repo.IngredientRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    private final IngredientRepo ingredientRepo;

    @Autowired
    public IngredientController(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public List<Ingredient> list(){
        return ingredientRepo.findAll();
    }

    @GetMapping("{id}")
    public Ingredient getOne(@PathVariable("id") Ingredient ingredient){
        return ingredient;
    }

    @PostMapping
    public Ingredient create(@RequestBody Ingredient ingredient){
        return ingredientRepo.save(ingredient);
    }

    @PutMapping("{id}")
    public Ingredient update(@PathVariable("id") Ingredient ingredientDb, @RequestBody Ingredient ingredient){
        BeanUtils.copyProperties(ingredient, ingredientDb, "id");
        return ingredientRepo.save(ingredientDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Ingredient ingredient){
        ingredientRepo.delete(ingredient);
    }
}
