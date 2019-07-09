package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<com.bolilyivs.cookbook.Entity.Role, Long> {
    com.bolilyivs.cookbook.Entity.Role findByName(String name);
}
