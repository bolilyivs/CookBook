package com.bolilyivs.cookbook.Controller;

import com.bolilyivs.cookbook.Entity.Tag;
import com.bolilyivs.cookbook.Repo.TagRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    private final TagRepo tagRepo;

    @Autowired
    public TagController(TagRepo tagRepo) {
        this.tagRepo = tagRepo;
    }

    @GetMapping
    public List<Tag> list(){
        return tagRepo.findAll();
    }

    @GetMapping("{id}")
    public Tag getOne(@PathVariable("id") Tag tag){
        return tag;
    }

    @PostMapping
    public Tag create(@RequestBody Tag tag){
        return tagRepo.save(tag);
    }

    @PutMapping("{id}")
    public Tag update(@PathVariable("id") Tag tagDb, @RequestBody Tag tag){
        BeanUtils.copyProperties(tag, tagDb, "id");
        return tagRepo.save(tagDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Tag tag){
        tagRepo.delete(tag);
    }
}
