package com.bolilyivs.cookbook;

import com.bolilyivs.cookbook.Entity.Account;

import com.bolilyivs.cookbook.Entity.TagName;
import com.bolilyivs.cookbook.Repo.AccountRepo;
import com.bolilyivs.cookbook.Repo.TagNameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication

public class CookbookApplication implements CommandLineRunner {

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private TagNameRepo tagNameRepo;


	public static void main(String[] args) {
		SpringApplication.run(CookbookApplication.class, args);
	}


	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Account user1 = new Account("user1", "123");
		user1.makeAdmin();
		accountRepo.save(user1);

		tagNameRepo.save(new TagName("tag1"));
		tagNameRepo.save(new TagName("tag2"));
		tagNameRepo.save(new TagName("tag3"));



	}
}
