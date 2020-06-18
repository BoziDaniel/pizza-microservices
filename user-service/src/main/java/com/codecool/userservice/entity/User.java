package com.codecool.userservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

//    @JsonIgnore
    private String password;

    @ElementCollection
    @Singular
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    public User(String username, String password, Set<UserRole> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}