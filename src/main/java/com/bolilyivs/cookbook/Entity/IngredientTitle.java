package com.bolilyivs.cookbook.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@ToString(of={"title"})
@EqualsAndHashCode(of = {"title"})
public class IngredientTitle {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String title;
}
