package com.cubex.survey.v1.services;

import com.cubex.survey.v1.models.Question;

public interface IQuestionService {

    public Question createQuestion(Question question);

    public Question updateQuestion(Question question);

    public void deleteQuestion(int id);

    public Question getQuestionBySurveyId(int surveyId);

    public Question getQuestionById(int id);

}
