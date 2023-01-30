package com.cubex.survey.v1.models;

import jakarta.persistence.*;
import lombok.Cleanup;

import java.util.List;

@Entity
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column()
    private String choice;

    @ManyToOne()
    private Question question;

    @OneToMany()
    private List<Response> responses;

}
