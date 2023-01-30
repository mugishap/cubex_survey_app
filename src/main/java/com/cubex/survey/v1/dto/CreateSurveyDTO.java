package com.cubex.survey.v1.dto;

import com.cubex.survey.v1.enums.ESurveyStatus;
import com.cubex.survey.v1.models.Question;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateSurveyDTO {

    private String name;
    private String description;
    private String image;
    private int userId;
    private ESurveyStatus status;

}
