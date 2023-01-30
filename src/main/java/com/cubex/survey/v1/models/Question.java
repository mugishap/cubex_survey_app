package com.cubex.survey.v1.models;

import com.cubex.survey.v1.enums.EQuestion;
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
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column()
    private String question;

    @Column()
    private EQuestion type;

    @OneToMany()
    private List<Choice> choices;

    @ManyToOne()
    private Survey survey;

    @OneToMany()
    private List<Response> responses;

}
