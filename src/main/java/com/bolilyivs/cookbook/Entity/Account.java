package com.bolilyivs.cookbook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@ToString(of={"username"})
@EqualsAndHashCode(of = {"id"})
public class Account{

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Getter
    @Setter
    @JsonIgnore
    private String[] roles;

    @Getter
    private String email;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Collection<Recipe> recipes;

    @OneToMany(mappedBy = "account")
    private Collection<RecipeRating> recipesRating;

    public Account() {}

    public Account(String username, String password, String[] roles, String email) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }

    public Account(String username, String password, String[] roles) {
        this.username = username;
        setPassword(password);
        this.roles = roles;
    }

    public Account(String username, String password) {
        this.username = username;
        setPassword(password);
        this.roles = new String[]{"ROLE_USER", "ROLE_ADMIN"};
    }

    public Account(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }
}
