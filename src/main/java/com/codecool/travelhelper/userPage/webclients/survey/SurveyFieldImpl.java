package com.codecool.travelhelper.userPage.webclients.survey;


import com.codecool.travelhelper.userPage.models.survey.SurveyFieldModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SurveyFieldImpl {

    public SurveyFieldModel surveyFieldBuilder(String question, Long questionId, List<String> answers, int chosenAnswerIndex, Long chosenAnswerId){
        return SurveyFieldModel.builder()
                .question(question)
                .questionId(questionId)
                .answersList(answers)
                .chosenAnswer(answers.get(chosenAnswerIndex))
                .chosenAnswerId(chosenAnswerId)
                .build();
    }
}
