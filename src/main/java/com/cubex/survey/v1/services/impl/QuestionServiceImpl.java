package com.cubex.survey.v1.services.impl;

import com.cubex.survey.v1.models.Question;
import com.cubex.survey.v1.models.Survey;
import com.cubex.survey.v1.repositories.IQuestionRepository;
import com.cubex.survey.v1.services.IQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private SurveyServiceImpl surveyService;

    @Override
    public Question createQuestion(Question question) {
        return this.questionRepository.save(question);
    }


    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(int id) {
        this.questionRepository.deleteById(id);
        return;
    }

    @Override
    public Question getQuestionById(int id) {
        return this.questionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Question> getQuestionsBySurveyId(int surveyId) {
        return this.questionRepository.findQuestionsBySurveyId(surveyId);
    }

    @Override
    public List<Question> saveMultipleQuestions(int surveyId, List<Question> questions) {
        questions.forEach(q->{
            System.out.println(q.getQuestion());
            System.out.println(q.getSurvey().getUser().getEmail());
        });
        for (Question question : questions) {
            Survey survey = surveyService.getSurvey(surveyId);
            question.setSurvey(survey);
        }
        return this.questionRepository.saveAll(questions);
    }
}
