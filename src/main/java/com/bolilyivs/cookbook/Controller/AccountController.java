package com.bolilyivs.cookbook.Controller;

import com.bolilyivs.cookbook.Entity.Account;
import com.bolilyivs.cookbook.Repo.AccountRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountRepo accountRepo;

    @Autowired
    public AccountController(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @GetMapping
    public List<Account> list(){
        return accountRepo.findAll();
    }

    @GetMapping("{id}")
    public Account getOne(@PathVariable("id") Account user){
        return user;
    }

    @PostMapping
    public Account create(@RequestBody Account user){
        return accountRepo.save(user);
    }

    @PutMapping("{id}")
    public Account update(@PathVariable("id") Account userDb, @RequestBody Account user){
        BeanUtils.copyProperties(user, userDb, "id");
        return accountRepo.save(userDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Account user){
        accountRepo.delete(user);
    }
}
