package com.cubex.survey.v1.controllers;

import com.cubex.survey.v1.dto.AddMultipleQuestionsDTO;
import com.cubex.survey.v1.dto.ApiResponse;
import com.cubex.survey.v1.dto.CreateSurveyDTO;
import com.cubex.survey.v1.dto.QuestionDTO;
import com.cubex.survey.v1.models.Question;
import com.cubex.survey.v1.models.Survey;
import com.cubex.survey.v1.models.User;
import com.cubex.survey.v1.services.impl.QuestionServiceImpl;
import com.cubex.survey.v1.services.impl.SurveyServiceImpl;
import com.cubex.survey.v1.services.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/surveys")
@Slf4j
@Api(consumes = "application/json", produces = "application/json", tags = "Survey Controller", value = "Survey Controller", description = "Survey Controller")
public class SurveyController {

    @Autowired
    private SurveyServiceImpl surveyService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private QuestionServiceImpl questionService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createSurvey(@RequestBody CreateSurveyDTO dto) {
        log.debug(String.valueOf(dto));
        User user = userService.getUserById(dto.getUserId());
        Survey survey = new Survey();
        survey.setName(dto.getName());
        survey.setDescription(dto.getDescription());
        survey.setUser(user);
        survey.setStatus(dto.getStatus());
        Survey entity = this.surveyService.createSurvey(survey);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/surveys/create").toUriString());
        return ResponseEntity.created(uri).body(new ApiResponse(true, "Survey created successfully", entity));
    }

    @PostMapping("/questions/multiple")
    public ResponseEntity<ApiResponse> addMultipleQuestions(@RequestBody AddMultipleQuestionsDTO dto) {
        List<Question> questions = new ArrayList<>();
        for (QuestionDTO questionDTO : dto.getQuestions()) {
            Question question = new Question();
            question.setQuestion(questionDTO.getQuestion());
            question.setSurvey(this.surveyService.getSurvey(dto.getSurveyId()));
            questions.add(question);
        }

        List<Question> entity = this.questionService.saveMultipleQuestions(dto.getSurveyId(), questions);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/surveys/questions/multiple").toUriString());
        return ResponseEntity.created(uri).body(new ApiResponse(true, "Questions added successfully", entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getSurveyById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok().body(new ApiResponse(true, "Survey fetched successfully", this.surveyService.getSurvey(id)));
    }
}
