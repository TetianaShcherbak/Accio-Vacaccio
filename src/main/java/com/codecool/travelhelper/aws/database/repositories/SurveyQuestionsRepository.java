package com.codecool.travelhelper.aws.database.repositories;

import com.codecool.travelhelper.aws.database.models.SurveyQuestionsTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyQuestionsRepository extends JpaRepository<SurveyQuestionsTable, Long> {
}
