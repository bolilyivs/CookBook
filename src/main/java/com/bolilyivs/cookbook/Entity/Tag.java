package com.bolilyivs.cookbook.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@ToString(of={"title", "description"})
@EqualsAndHashCode(of = {"id"})
public class Tag {

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
    @ManyToMany(mappedBy = "tags")
    private Collection<Recipe> recipes;
}
