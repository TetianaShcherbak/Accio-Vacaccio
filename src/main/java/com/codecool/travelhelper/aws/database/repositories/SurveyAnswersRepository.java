package com.codecool.travelhelper.aws.database.repositories;

import com.codecool.travelhelper.aws.database.models.MyUserTable;
import com.codecool.travelhelper.aws.database.models.SurveyAnswersTable;
import com.codecool.travelhelper.aws.database.models.SurveyQuestionsTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyAnswersRepository extends JpaRepository<SurveyAnswersTable, Long> {
    List<SurveyAnswersTable> getAllByQuestion(SurveyQuestionsTable question);

    List<SurveyAnswersTable> getAllByUsersList(List<MyUserTable> usersList);


}
