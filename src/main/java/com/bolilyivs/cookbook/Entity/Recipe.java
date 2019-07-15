package com.bolilyivs.cookbook.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@ToString(of={"id","title", "description", "ingredients", "tags"})
@EqualsAndHashCode(of = {"id"})
public class Recipe {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    @Column(length=100000)
    private String description;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "RECIPE_INGREDIENT",
            joinColumns = @JoinColumn(name = "RECIPE_ID"),
            inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID")
    )
    private Set<Ingredient> ingredients  = new HashSet<Ingredient>();

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "RECIPE_TAGS",
            joinColumns = @JoinColumn(name = "RECIPE_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    private Set<Tag> tags  = new HashSet<Tag>();

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Getter
    @Setter
    private Long rating;

    @Getter
    @Setter
    private Boolean hide = false;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<RecipeRating> recipesRating;

    public Recipe(String title, String description, Set<Ingredient> ingredients, Set<Tag> tags, Account account, Long rating, Boolean hide) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.tags = tags;
        this.account = account;
        this.rating = rating;
        this.hide = hide;
    }

    public Recipe(Long id, String title, String description, Set<Ingredient> ingredients, Set<Tag> tags, Account account, Long rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.tags = tags;
        this.account = account;
        this.rating = rating;
    }

    public Recipe(){};
}
