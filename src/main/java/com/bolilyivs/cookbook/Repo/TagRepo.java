package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag, Long> {
}
