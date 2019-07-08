package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.IngredientTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientTitleRepo extends JpaRepository<IngredientTitle, Long> {
}
