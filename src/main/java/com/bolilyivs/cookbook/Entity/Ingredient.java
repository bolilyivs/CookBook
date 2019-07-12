package com.bolilyivs.cookbook.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@ToString(of={"id","title", "amount"})
@EqualsAndHashCode(of = {"title", "amount"})
public class Ingredient {

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
    private String amount;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "ingredients")
    @JsonIgnore
    private Set<Recipe> recipes;

    public Ingredient(){}

    public Ingredient(Long id, String title, String amount, Set<Recipe> recipes) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.recipes = recipes;
    }

    public Ingredient(String title, String amount){
        this.title = title;
        this.amount = amount;
    }
}
