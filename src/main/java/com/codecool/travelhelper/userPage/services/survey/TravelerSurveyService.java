package com.codecool.travelhelper.userPage.services.survey;

import com.codecool.travelhelper.userPage.models.survey.SurveyFieldModel;
import com.codecool.travelhelper.userPage.models.survey.TravelerSurveyModel;
import com.codecool.travelhelper.userPage.webclients.survey.SurveyFieldImpl;
import com.codecool.travelhelper.userPage.webclients.survey.TravelSurveyImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelerSurveyService {
    @Autowired
    TravelSurveyImpl travelSurvey;

    public TravelerSurveyModel getTravelerSurveyModel(String userId){
        return travelSurvey.surveyBuilder(userId);
    }

    public void updateSurvey(String userId, String chosenAnswers){
        travelSurvey.updateSurvey(userId, chosenAnswers);
    }
}
