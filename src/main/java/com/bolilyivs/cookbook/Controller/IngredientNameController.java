package com.bolilyivs.cookbook.Controller;

import com.bolilyivs.cookbook.Entity.IngredientName;
import com.bolilyivs.cookbook.Repo.IngredientNameRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient/name")
public class IngredientNameController {
    private final IngredientNameRepo ingredientNameRepo;

    @Autowired
    public IngredientNameController(IngredientNameRepo ingredientNameRepo) {
        this.ingredientNameRepo = ingredientNameRepo;
    }

    @GetMapping
    public List<IngredientName> list(){
        return ingredientNameRepo.findAll();
    }

    @GetMapping("{id}")
    public IngredientName getOne(@PathVariable("id") IngredientName ingredientName){
        return ingredientName;
    }

    @PostMapping
    public IngredientName create(@RequestBody IngredientName ingredientName){
        return ingredientNameRepo.save(ingredientName);
    }

    @PutMapping("{id}")
    public IngredientName update(@PathVariable("id") IngredientName ingredientNameDb, @RequestBody IngredientName ingredientName){
        BeanUtils.copyProperties(ingredientName, ingredientNameDb, "id");
        return ingredientNameRepo.save(ingredientNameDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") IngredientName ingredientName){
        ingredientNameRepo.delete(ingredientName);
    }
}
