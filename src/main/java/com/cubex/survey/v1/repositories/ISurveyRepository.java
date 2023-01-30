package com.cubex.survey.v1.repositories;

import com.cubex.survey.v1.models.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISurveyRepository extends JpaRepository<Survey, Integer> {

    @Query("SELECT s FROM Survey s WHERE s.user.id = ?1")
    List<Survey> findSurveysByUserId(int userId);

}
