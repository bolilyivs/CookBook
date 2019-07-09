package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.IngredientName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientNameRepo extends JpaRepository<IngredientName, Long> {
}
