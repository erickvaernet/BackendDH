package com.example.integradorV2.Entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users", indexes = @Index(columnList = "username"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = true)
    private String email;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role rol;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,name = "last_name")
    private String lastName;


}
