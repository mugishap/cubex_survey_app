package com.cubex.survey.v1.services;

import com.cubex.survey.v1.models.Question;

import java.util.List;

public interface IQuestionService {

    public Question createQuestion(Question question);

    public Question updateQuestion(Question question);

    public void deleteQuestion(int id);

    public Question getQuestionById(int id);

    public List<Question> getQuestionsBySurveyId(int surveyId);

    public List<Question> saveMultipleQuestions(int surveyId, List<Question> questions);



}
