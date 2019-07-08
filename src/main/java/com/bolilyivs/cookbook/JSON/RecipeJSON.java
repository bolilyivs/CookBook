package com.bolilyivs.cookbook.JSON;

import com.bolilyivs.cookbook.Entity.Recipe;
import com.bolilyivs.cookbook.Repo.RecipeRepo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
public class RecipeJSON {
    public long id;
    public String title;
    public String description;
    public String account;
    public String rating;
    public List<String> tags;
    public List<IngredientJSON> ingredients;

    public boolean isEmptyTagsAndIngredients(){
        return isEmptyTags() && isEmptyIngredients();
    }

    public boolean isEmptyTags(){
        return this.tags.isEmpty();
    }

    public boolean isEmptyIngredients(){
        return this.ingredients.isEmpty();
    }
}
