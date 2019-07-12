package com.bolilyivs.cookbook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table
@ToString(of={"id","title"})
@EqualsAndHashCode(of = {"title"})
public class Tag {

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
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    @JsonIgnore
    private Set<Recipe> recipes;

    public Tag(){};

    public Tag(String title){
        this.title =title;
    };
}
