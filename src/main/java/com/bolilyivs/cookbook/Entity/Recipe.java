package com.bolilyivs.cookbook.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@ToString(of={"title", "description"})
@EqualsAndHashCode(of = {"id"})
public class Recipe {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String ingredients;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "RECIPE_TAGS",
            joinColumns = @JoinColumn(name = "RECIPE_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    private Collection<Tag> tags;

    @Getter
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Getter
    @Setter
    private Long rating;
}
