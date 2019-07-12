package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IngredientRepo extends JpaRepository<Ingredient, Long> {

}
