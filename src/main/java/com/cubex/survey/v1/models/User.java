package com.cubex.survey.v1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany()
    private List<Survey> surveys;

    public User(String names, String email, String profileImage, String password) {
        this.names = names;
        this.email = email;
        this.profileImage = profileImage;
        this.password = password;
    }
}
