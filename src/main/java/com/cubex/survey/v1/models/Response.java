package com.cubex.survey.v1.models;

import jakarta.persistence.*;

@Entity
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Survey surveyId;

    @ManyToOne
    private Question questionId;

    @ManyToOne
    private Choice choice;

    private String answer;

    @ManyToOne
    private User responder;


}
