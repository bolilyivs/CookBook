package com.bolilyivs.cookbook.Controller;

import com.bolilyivs.cookbook.Entity.IngredientTitle;
import com.bolilyivs.cookbook.Repo.IngredientTitleRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient/title")
public class IngredientTitleController {
    private final IngredientTitleRepo ingredientTitleRepo;

    @Autowired
    public IngredientTitleController(IngredientTitleRepo ingredientTitleRepo) {
        this.ingredientTitleRepo = ingredientTitleRepo;
    }

    @GetMapping
    public List<IngredientTitle> list(){
        return ingredientTitleRepo.findAll();
    }

    @GetMapping("{id}")
    public IngredientTitle getOne(@PathVariable("id") IngredientTitle ingredientTitle){
        return ingredientTitle;
    }

    @PostMapping
    public IngredientTitle create(@RequestBody IngredientTitle ingredientTitle){
        return ingredientTitleRepo.save(ingredientTitle);
    }

    @PutMapping("{id}")
    public IngredientTitle update(@PathVariable("id") IngredientTitle ingredientTitleDb, @RequestBody IngredientTitle ingredientTitle){
        BeanUtils.copyProperties(ingredientTitle, ingredientTitleDb, "id");
        return ingredientTitleRepo.save(ingredientTitleDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") IngredientTitle ingredientTitle){
        ingredientTitleRepo.delete(ingredientTitle);
    }
}
