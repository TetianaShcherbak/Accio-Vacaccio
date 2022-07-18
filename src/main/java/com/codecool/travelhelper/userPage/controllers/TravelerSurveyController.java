package com.codecool.travelhelper.userPage.controllers;

import com.codecool.travelhelper.userPage.models.PlaceWantToGoModel;
import com.codecool.travelhelper.userPage.models.survey.TravelerSurveyModel;
import com.codecool.travelhelper.userPage.services.survey.TravelerSurveyService;
import com.codecool.travelhelper.userPage.webclients.PlacesWantToGoImpl;
import com.codecool.travelhelper.userPage.webclients.survey.TravelSurveyImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class TravelerSurveyController {

    @Autowired
    TravelerSurveyService service;

    @PutMapping("/update/survey/content/{userId}")
    public void updateSurveyContent(@PathVariable String userId, @RequestBody String chosenAnswers) {
        service.updateSurvey(userId, chosenAnswers);
    }

    @GetMapping("/get/survey/content/{userId}")
    public TravelerSurveyModel getSurveyContent(@PathVariable String userId) {
        return service.getTravelerSurveyModel(userId);
    }
}
