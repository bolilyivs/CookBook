package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.Account;
import com.bolilyivs.cookbook.Entity.Recipe;
import com.bolilyivs.cookbook.Entity.RecipeRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRatingRepo  extends JpaRepository<RecipeRating, Long> {

    boolean existsByAccountAndRecipe(Account account, Recipe recipe);
    RecipeRating findByAccountAndRecipe(Account account, Recipe recipe);
}
