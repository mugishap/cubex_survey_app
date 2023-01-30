package com.cubex.survey.v1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/survey")
public class Survey {

    @GetMapping("/")
    public String getSurvey() {
        return "Survey";
    }

}
