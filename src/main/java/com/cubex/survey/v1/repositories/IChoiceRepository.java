package com.cubex.survey.v1.repositories;

import com.cubex.survey.v1.models.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChoiceRepository extends JpaRepository<Choice, Integer> {
}

