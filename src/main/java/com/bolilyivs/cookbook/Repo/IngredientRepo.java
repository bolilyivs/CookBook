package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.Ingredient;
import com.bolilyivs.cookbook.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
}
