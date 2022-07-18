package com.codecool.travelhelper.userPage.services.survey;

import com.codecool.travelhelper.userPage.models.survey.SurveyFieldModel;
import com.codecool.travelhelper.userPage.webclients.survey.SurveyFieldImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyFieldService {
    @Autowired
    SurveyFieldImpl surveyField;

    public SurveyFieldModel getSurveyField(String question, Long questionId, List<String> answers, int chosenAnswerIndex, Long chosenAnswerId){
        return surveyField.surveyFieldBuilder(question, questionId, answers, chosenAnswerIndex, chosenAnswerId);
    }
}
