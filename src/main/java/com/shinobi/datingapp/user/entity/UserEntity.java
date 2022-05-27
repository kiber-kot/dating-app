package com.shinobi.datingapp.user.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String name;

    private String email;

    private String appleId;

    private String googleId;

    private int age;

    private String password;


}
