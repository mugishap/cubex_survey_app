package com.cubex.survey.v1.models;

import com.cubex.survey.v1.enums.ESurveyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column()
    private String name;

    @Column()
    private String description;

    @Column()
    private String image;

    @ManyToOne()
    private User user;

    @Column()
    private ESurveyStatus status;

    @OneToMany()
    private List<Question> questions;

    public Survey(String name, String description, String image, User user, ESurveyStatus status, List<Question> questions) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.user = user;
        this.status = status;
        this.questions = questions;
    }
}
