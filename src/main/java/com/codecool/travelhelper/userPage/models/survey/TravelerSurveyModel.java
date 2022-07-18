package com.codecool.travelhelper.userPage.models.survey;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TravelerSurveyModel {
    List<SurveyFieldModel> surveyField;
}
