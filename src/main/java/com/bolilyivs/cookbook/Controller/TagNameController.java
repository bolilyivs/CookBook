package com.bolilyivs.cookbook.Controller;

import com.bolilyivs.cookbook.Entity.TagName;
import com.bolilyivs.cookbook.Repo.TagNameRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag/name")
public class TagNameController {

    @Autowired
    private final TagNameRepo tagNameRepo;

    @Autowired
    public TagNameController(TagNameRepo tagNameRepo) {
        this.tagNameRepo = tagNameRepo;
    }

    @GetMapping
    public List<TagName> list(){
        return tagNameRepo.findAll();
    }

    @GetMapping("{id}")
    public TagName getOne(@PathVariable("id") TagName tagName){
        return tagName;
    }

    @PostMapping
    public TagName create(@RequestBody TagName tagName){
        return tagNameRepo.save(tagName);
    }

    @PutMapping("{id}")
    public TagName update(@PathVariable("id") TagName tagNameDb, @RequestBody TagName tagName){
        BeanUtils.copyProperties(tagName, tagNameDb, "id");
        return tagNameRepo.save(tagNameDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") TagName tagName){
        tagNameRepo.delete(tagName);
    }
}
