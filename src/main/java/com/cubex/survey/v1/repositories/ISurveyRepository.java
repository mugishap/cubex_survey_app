package com.cubex.survey.v1.repositories;

import com.cubex.survey.v1.models.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISurveyRepository extends JpaRepository<Survey, Integer> {
}
