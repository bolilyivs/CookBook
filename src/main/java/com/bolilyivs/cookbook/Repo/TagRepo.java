package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.Recipe;
import com.bolilyivs.cookbook.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TagRepo extends JpaRepository<Tag, Long> {
    Tag findByTitle(String string);

}
