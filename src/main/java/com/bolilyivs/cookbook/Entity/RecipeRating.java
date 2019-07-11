package com.bolilyivs.cookbook.Entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString(of={"id", "rating", "account", "recipe"})
@EqualsAndHashCode(of = {"id"})
public class RecipeRating {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private  Short rating;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "RECIPE_ID")
    private Recipe recipe;

    public RecipeRating(Account account, Recipe recipe, Short rating ) {
        this.rating = rating;
        this.account = account;
        this.recipe = recipe;
    }

    public RecipeRating() {

    }
}
