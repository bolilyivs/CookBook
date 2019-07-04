package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
}
