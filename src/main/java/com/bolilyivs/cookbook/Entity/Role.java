package com.bolilyivs.cookbook.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@ToString(of={"name"})
@EqualsAndHashCode(of = {"name"})
public class Role {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role(){}
}
