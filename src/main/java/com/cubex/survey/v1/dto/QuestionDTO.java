package com.cubex.survey.v1.dto;

import com.cubex.survey.v1.enums.EQuestion;
import lombok.Getter;

import java.util.List;

@Getter
public class QuestionDTO {

    private String question;
    private EQuestion type;
    private List<ChoiceDTO> choices;

}
