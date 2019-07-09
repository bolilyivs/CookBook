package com.bolilyivs.cookbook.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@ToString(of={"name"})
@EqualsAndHashCode(of = {"name"})
public class IngredientName {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    public IngredientName(String name) {
        this.name = name;
    }

    public IngredientName() {
    }
}
