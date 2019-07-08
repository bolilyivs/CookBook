package com.bolilyivs.cookbook;

import com.bolilyivs.cookbook.Entity.Account;
import com.bolilyivs.cookbook.Repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication

public class CookbookApplication implements CommandLineRunner {

	@Autowired
	private AccountRepo accountRepo;

	public static void main(String[] args) {
		SpringApplication.run(CookbookApplication.class, args);
	}


	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Account user1 = new Account("user1", "123");
		accountRepo.save(user1);
	}
}
