package com.cubex.survey.v1.repositories;

import com.cubex.survey.v1.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IQuestionRepository extends JpaRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.survey.id = ?1")
    List<Question> findQuestionsBySurveyId(int surveyId);
}
