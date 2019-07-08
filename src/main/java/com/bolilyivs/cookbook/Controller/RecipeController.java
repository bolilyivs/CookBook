package com.bolilyivs.cookbook.Controller;

import com.bolilyivs.cookbook.Entity.Ingredient;
import com.bolilyivs.cookbook.Entity.Recipe;
import com.bolilyivs.cookbook.Entity.Account;
import com.bolilyivs.cookbook.Entity.Tag;
import com.bolilyivs.cookbook.JSON.IngredientJSON;
import com.bolilyivs.cookbook.JSON.RecipeFinder;
import com.bolilyivs.cookbook.JSON.RecipeJSON;
import com.bolilyivs.cookbook.Repo.AccountRepo;
import com.bolilyivs.cookbook.Repo.IngredientRepo;
import com.bolilyivs.cookbook.Repo.RecipeRepo;
import com.bolilyivs.cookbook.Repo.TagRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@RestController
@RequestMapping(value = "/api/recipe", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeController {

    @Autowired
    private final RecipeRepo recipeRepo;
    @Autowired
    private final TagRepo tagRepo;
    @Autowired
    private final IngredientRepo ingredientRepo;
    @Autowired
    private final AccountRepo accountRepo;

    @Autowired
    public RecipeController(RecipeRepo recipeRepo, TagRepo tagRepo, IngredientRepo ingredientRepo, AccountRepo accountRepo) {
        this.recipeRepo = recipeRepo;
        this.tagRepo = tagRepo;
        this.ingredientRepo = ingredientRepo;
        this.accountRepo = accountRepo;
    }

    @GetMapping
    public List<Recipe> list(){

        return recipeRepo.findAll();
    }

    @PostMapping(path = "/find")
    public List<Recipe> getByTags(@RequestBody RecipeFinder finder){
        List<Recipe> recipeList;
        System.out.println(finder.title);
        finder.tags.add("all");
        finder.ingredients.add("all");
        recipeList = recipeRepo.searchAllTitleUsernameTagsIngredients(finder.title,finder.username,
                finder.tags,(long) finder.tags.size(), finder.ingredients, (long) finder.ingredients.size(),
                PageRequest.of(0, 10, Direction.DESC, "rating"));
        for (Recipe recipe: recipeList) {
            recipe.getIngredients().remove(new Ingredient("all", "all"));
        }
        return recipeList;
    }

    @GetMapping("{id}")
    public Recipe getOne(@PathVariable("id") Recipe recipe){
        recipe.getIngredients().remove(new Ingredient("all", "all"));
        return recipe;
    }

    @PostMapping
    public Recipe create(@RequestBody Recipe recipe){
        recipe.setAccount(accountRepo.findByUsername("user1"));
        recipe.getIngredients().add(new Ingredient("all", "all"));
        recipe.getTags().add(new Tag("all"));
        System.out.println(recipe);
        return recipeRepo.save(recipe);
    }

    @PutMapping("{id}/update")
    public Recipe update(@PathVariable("id") Recipe recipeDB, @RequestBody Recipe recipe){
        System.out.println(recipeDB);
        recipeDB.setTitle(recipe.getTitle());
        recipeDB.setDescription(recipe.getDescription());
        recipeDB.setIngredients(recipe.getIngredients());
        recipeDB.setTags(recipe.getTags());

        recipeDB.getIngredients().add(new Ingredient("all", "all"));
        recipeDB.getTags().add(new Tag("all"));

        System.out.println(recipeDB);
        return recipeRepo.save(recipeDB);
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable("id") Recipe recipe){
        recipeRepo.delete(recipe);
    }
}
