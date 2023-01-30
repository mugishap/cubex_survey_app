package com.cubex.survey.v1.models;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column()
    private String names;

    @Column()
    private String email;

    @Column()
    private String profileImage;

    @Column()
    private String password;

}
