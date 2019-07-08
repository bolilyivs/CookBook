package com.bolilyivs.cookbook.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@ToString(of={"username"})
@EqualsAndHashCode(of = {"id"})
public class Account {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Collection<Recipe> recipes;

    public Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username) {
        this.username = username;
    }
}
