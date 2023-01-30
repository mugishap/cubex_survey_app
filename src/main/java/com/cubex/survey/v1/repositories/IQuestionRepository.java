package com.cubex.survey.v1.repositories;

import com.cubex.survey.v1.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<Question, Integer> {
}
