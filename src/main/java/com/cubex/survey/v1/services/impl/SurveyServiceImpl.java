package com.cubex.survey.v1.services.impl;

import com.cubex.survey.v1.enums.ESurveyStatus;
import com.cubex.survey.v1.models.Survey;
import com.cubex.survey.v1.repositories.ISurveyRepository;
import com.cubex.survey.v1.services.ISurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SurveyServiceImpl implements ISurveyService {

    @Autowired
    private ISurveyRepository surveyRepository;

    @Override
    public Survey createSurvey(Survey survey) {
        return this.surveyRepository.save(survey);
    }

    @Override
    public String shareSurvey(int surveyId) {
        return "https://cubex-survey.vercel.app/survey/invite/" + surveyId;
    }

    @Override
    public Survey getSurvey(int surveyId) {
        return this.surveyRepository.findById(surveyId).orElse(null);
    }

    @Override
    public void deleteSurvey(int surveyId) {
        this.surveyRepository.deleteById(surveyId);
        return;
    }

    @Override
    public List<Survey> getSurveysByUserId(int userId) {
        return this.surveyRepository.findSurveysByUserId(userId);
    }

    @Override
    public Survey publishSurvey(int surveyId) {
        Survey survey = this.surveyRepository.findById(surveyId).orElse(null);
        if (survey != null) {
            survey.setStatus(ESurveyStatus.PUBLISHED);
            return this.surveyRepository.save(survey);
        } else {
            return null;
        }
    }

    @Override
    public Survey updateSurvey(Survey survey) {
        return this.surveyRepository.save(survey);
    }
}
