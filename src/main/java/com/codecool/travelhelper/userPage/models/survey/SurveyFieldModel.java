package com.codecool.travelhelper.userPage.models.survey;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SurveyFieldModel {
    String question;
    Long questionId;
    List<String> answersList;
    String chosenAnswer;
    Long chosenAnswerId;
}
