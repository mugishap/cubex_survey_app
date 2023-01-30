package com.cubex.survey.v1.dto;

import com.cubex.survey.v1.models.Question;
import lombok.Getter;

import java.util.List;

@Getter
public class AddMultipleQuestionsDTO {

    private int surveyId;
    private List<QuestionDTO> questions;

}
