package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
