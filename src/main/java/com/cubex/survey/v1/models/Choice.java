package com.cubex.survey.v1.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
