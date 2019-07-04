package com.bolilyivs.cookbook.Controller;

import com.bolilyivs.cookbook.Entity.Recipe;
import com.bolilyivs.cookbook.Repo.RecipeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeRepo recipeRepo;

    @Autowired
    public RecipeController(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @GetMapping
    public List<Recipe> list(){
        return recipeRepo.findAll();
    }

    @GetMapping("{id}")
    public Recipe getOne(@PathVariable("id") Recipe recipe){
        return recipe;
    }

    @PostMapping
    public Recipe create(@RequestBody Recipe recipe){
        return recipeRepo.save(recipe);
    }

    @PutMapping("{id}")
    public Recipe update(@PathVariable("id") Recipe recipeDb, @RequestBody Recipe recipe){
        BeanUtils.copyProperties(recipe, recipeDb, "id");
        return recipeRepo.save(recipeDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Recipe recipe){
        recipeRepo.delete(recipe);
    }
}
