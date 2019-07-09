package com.bolilyivs.cookbook.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString(of={"name"})
@EqualsAndHashCode(of = {"name"})
public class TagName {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    public TagName(String name) {
        this.name = name;
    }

    public TagName() {
    }
}
