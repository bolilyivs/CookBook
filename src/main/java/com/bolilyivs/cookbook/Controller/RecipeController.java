package com.bolilyivs.cookbook.Controller;

import com.bolilyivs.cookbook.Entity.*;
import com.bolilyivs.cookbook.JSON.RecipeFinder;
import com.bolilyivs.cookbook.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
    private final RecipeRatingRepo recipeRatingRepo;

    @Autowired
    public RecipeController(RecipeRepo recipeRepo, TagRepo tagRepo, IngredientRepo ingredientRepo, AccountRepo accountRepo, RecipeRatingRepo recipeRatingRepo) {
        this.recipeRepo = recipeRepo;
        this.tagRepo = tagRepo;
        this.ingredientRepo = ingredientRepo;
        this.accountRepo = accountRepo;
        this.recipeRatingRepo = recipeRatingRepo;
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
        return recipeList;
    }

    @GetMapping("{id}")
    public Recipe getOne(@PathVariable("id") Recipe recipe){
        return recipe;
    }

    @PostMapping("/create")
    public Recipe create(@RequestBody Recipe recipe){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        recipe.setAccount(accountRepo.findByUsername(auth.getName()));
        recipe.getIngredients().add(new Ingredient("all", "all"));
        recipe.getTags().add(new Tag("all"));
        System.out.println(recipe);
        return recipeRepo.save(recipe);
    }


    @PutMapping("/update/{id}")
    public Recipe update(@PathVariable("id") Recipe recipeDB, @RequestBody Recipe recipe){
        recipeRepo.save(recipeDB);
        recipeDB.setTitle(recipe.getTitle());
        recipeDB.setDescription(recipe.getDescription());
        recipeDB.setIngredients(recipe.getIngredients());
        recipeDB.setTags(recipe.getTags());
        System.out.println(recipeDB);
        return recipeRepo.save(recipeDB);
    }

    @GetMapping("/rating/plus/{id}")
    public Recipe ratingPlus(@PathVariable("id") Recipe recipe){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountRepo.findByUsername(auth.getName());

        System.out.println("test " + account.getUsername());

        if(recipeRatingRepo.existsByAccountAndRecipe(account, recipe)){
            RecipeRating rating = recipeRatingRepo.findByAccountAndRecipe(account, recipe);
            System.out.println(rating + " " + account);
            if(rating.getRating() == -1){
                rating.setRating((short) 1);
                recipe.setRating(recipe.getRating()+2);
            }else if(rating.getRating() == 1){
                rating.setRating((short)0);
                recipe.setRating(recipe.getRating()-1);
            }else{
                rating.setRating((short) 1);
                recipe.setRating(recipe.getRating()+1);
            }
            recipeRatingRepo.save(rating);
            return recipeRepo.save(recipe);
        }

        recipeRatingRepo.save(new RecipeRating(account, recipe, (short)+1));
        recipe.setRating(recipe.getRating()+1);
        return recipeRepo.save(recipe);
    }

    @GetMapping("/rating/minus/{id}")
    public Recipe ratingMinus(@PathVariable("id") Recipe recipe){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountRepo.findByUsername(auth.getName());

        if(recipeRatingRepo.existsByAccountAndRecipe(account, recipe)){
            RecipeRating rating = recipeRatingRepo.findByAccountAndRecipe(account, recipe);
            if(rating.getRating() == -1){
                rating.setRating((short)0);
                recipe.setRating(recipe.getRating()+1);
            }else if(rating.getRating() == 1){
                rating.setRating((short)-1);
                recipe.setRating(recipe.getRating()-2);
            }else{
                rating.setRating((short)-1);
                recipe.setRating(recipe.getRating()-1);
            }

            recipeRatingRepo.save(rating);
            return recipeRepo.save(recipe);
        }

        recipeRatingRepo.save(new RecipeRating(account, recipe, (short)+1));
        recipe.setRating(recipe.getRating()-1);
        return recipeRepo.save(recipe);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") Recipe recipe){
        recipeRepo.delete(recipe);
    }
}
