package com.cubex.survey.v1.services;

import com.cubex.survey.v1.models.Survey;

import java.util.List;

public interface ISurveyService {

    public Survey createSurvey(Survey survey);

    public String shareSurvey(int surveyId);

    public Survey getSurvey(int surveyId);

    public void deleteSurvey(int surveyId);

    public List<Survey> getSurveysByUserId(int userId);

    public Survey publishSurvey(int surveyId);

    public Survey updateSurvey(Survey survey);

}
