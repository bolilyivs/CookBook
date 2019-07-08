package com.bolilyivs.cookbook.JSON;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;

@Data
public class RecipeFinder {

    public String title;
    public String username;
    public HashSet<String> tags;
    public HashSet<String> ingredients;

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
