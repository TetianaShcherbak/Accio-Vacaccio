package com.codecool.travelhelper.userPage.webclients.survey;

import com.codecool.travelhelper.aws.database.models.SurveyAnswersTable;
import com.codecool.travelhelper.aws.database.models.SurveyQuestionsTable;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Component;

import java.util.*;

@RequiredArgsConstructor
@Component
public class SurveyBank {
    private Map<SurveyQuestionsTable, List<SurveyAnswersTable>> surveyBank;

    public Map<SurveyQuestionsTable, List<SurveyAnswersTable>> getSurveyBank(){
        fillSurveyBank();
        return surveyBank;
    }

    private void fillSurveyBank() {
        surveyBank = new HashMap<>();

        addSurveyField(new SurveyQuestionsTable(1L, "Are you going to use your own car this trip?"),
                new SurveyAnswersTable(1L, "Yes"),
                new SurveyAnswersTable(2L, "No"));

        addSurveyField(new SurveyQuestionsTable(2L, "Are you going to rent a car this trip?"),
                new SurveyAnswersTable(3L, "Yes"),
                new SurveyAnswersTable(4L, "No"));

        addSurveyField(new SurveyQuestionsTable(3L, "How many adults are going on this trip?"),
                new SurveyAnswersTable(5L, "Only me"),
                new SurveyAnswersTable(6L, "Two persons"),
                new SurveyAnswersTable(7L, "Three persons"),
                new SurveyAnswersTable(8L, "Four persons"),
                new SurveyAnswersTable(9L, "5+ persons"));

        addSurveyField(new SurveyQuestionsTable(4L, "How many children are going on this trip?"),
                new SurveyAnswersTable(10L, "Adults only"),
                new SurveyAnswersTable(11L, "One child"),
                new SurveyAnswersTable(12L, "Two children"),
                new SurveyAnswersTable(13L, "3+ children"));

    }

    private void addSurveyField(SurveyQuestionsTable question, SurveyAnswersTable ... answers){
        List<SurveyAnswersTable> answersList = new ArrayList<>(Arrays.asList(answers));
        surveyBank.put(question, answersList);
    }

}
