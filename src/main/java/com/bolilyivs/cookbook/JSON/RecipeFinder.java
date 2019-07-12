package com.bolilyivs.cookbook.JSON;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;

@Data
public class RecipeFinder {

    public String title;
    public String username;
    public HashSet<String> tags = new HashSet<String>();
    public HashSet<String> ingredients = new HashSet<String>();
    public int page = 0;
    public int size = 10;

    public RecipeFinder(String username, HashSet<String> tags, HashSet<String> ingredients, int page, int size) {
        this.username = username;
        this.tags = tags;
        this.ingredients = ingredients;
        this.page = page;
        this.size = size;
    }

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
