package com.codecool.travelhelper.userPage.webclients.survey;

import com.codecool.travelhelper.aws.database.models.MyUserTable;
import com.codecool.travelhelper.aws.database.models.SurveyAnswersTable;
import com.codecool.travelhelper.aws.database.models.SurveyQuestionsTable;
import com.codecool.travelhelper.aws.database.repositories.SurveyAnswersRepository;
import com.codecool.travelhelper.aws.database.repositories.SurveyQuestionsRepository;
import com.codecool.travelhelper.aws.database.repositories.UserRepository;
import com.codecool.travelhelper.userPage.models.survey.SurveyFieldModel;
import com.codecool.travelhelper.userPage.models.survey.TravelerSurveyModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TravelSurveyImpl {

    @Autowired
    SurveyBank surveyBank;

    @Autowired
    SurveyFieldImpl surveyFieldImpl;

    @Autowired
    SurveyAnswersRepository answersRepository;

    @Autowired
    SurveyQuestionsRepository questionsRepository;

    @Autowired
    UserRepository userRepository;


    public TravelerSurveyModel surveyBuilder(String userId){
        List<SurveyFieldModel>  survey = getSurveyFromDB(userId);

        if (survey.isEmpty()){
            survey = getSurveyFromBank();
        }

        return TravelerSurveyModel.builder()
                .surveyField(survey)
                .build();
    }


    /**
     * Example chosenAnswers = {
     *     chosen_answer_id_list: [id_1, id_2, ...]
     * }
     *
     * @param userId
     * @param chosenAnswers
     */
    public void updateSurvey(String userId, String chosenAnswers){
        List<SurveyAnswersTable> newAnswers = new ArrayList<>();

        JsonParser jsonParser = new JsonParser();
        JsonObject surveyJsonObject = (JsonObject)jsonParser.parse(chosenAnswers);
        JsonArray chosenAnswerIdList = surveyJsonObject.get("chosen_answer_id_list").getAsJsonArray();

        MyUserTable user = userRepository.getOne(Long.valueOf(userId));

        for (JsonElement chosenAnswerId: chosenAnswerIdList) {
            Long answerId = Long.valueOf(chosenAnswerId.getAsString());
            SurveyAnswersTable answersTable = answersRepository.findById(answerId).get();
            answersTable.getUsersList().add(user);
            newAnswers.add(answersTable);
        }

        user.setChosenAnswers(newAnswers);

        userRepository.save(user);
    }


//------------------------- secondary functions for creating Survey from data (from DB or Bank if DB is empty) ------------------//
    private List<SurveyFieldModel> getSurveyFromBank(){
        Map<SurveyQuestionsTable, List<SurveyAnswersTable>> currentSurveyBank = surveyBank.getSurveyBank();
        List<SurveyFieldModel>  survey = new ArrayList<>();

        for (var entry: currentSurveyBank.entrySet()) {
            SurveyQuestionsTable question = entry.getKey();
            List<SurveyAnswersTable> answers = entry.getValue();

            List<String> answersContent = new ArrayList<>();
            for (SurveyAnswersTable answer: answers) {
                answersContent.add(answer.getAnswer());
            }

            SurveyFieldModel surveyField = surveyFieldImpl.surveyFieldBuilder(question.getQuestion(), question.getId(), answersContent, 0, answers.get(0).getId());
            survey.add(surveyField);
        }
        return survey;
    }

    private List<SurveyFieldModel> getSurveyFromDB(String userId){
        List<SurveyFieldModel> survey = new ArrayList<>();
        List<SurveyQuestionsTable> questionTables = questionsRepository.findAll();

        for (SurveyQuestionsTable questionTable : questionTables) {
            SurveyFieldModel surveyField = getSurveyFieldModel(questionTable, userId);
            survey.add(surveyField);
        }

        return survey;
    }

    private SurveyFieldModel getSurveyFieldModel(SurveyQuestionsTable questionTable, String userId){
        String question = questionTable.getQuestion();

        Long questionId = questionTable.getId();

        List<SurveyAnswersTable> answerTables = answersRepository.getAllByQuestion(questionTable);

        List<String> answers = getAnswersForQuestion(answerTables, questionId);

        int chosenAnswerIndex = getChosenAnswerIndex(answerTables, Long.valueOf(userId));
        Long chosenAnswerId = getChosenAnswerIdForGivenQuestionByUser(questionTable, userId);

        SurveyFieldModel surveyField = surveyFieldImpl.surveyFieldBuilder(question,questionId, answers, chosenAnswerIndex, chosenAnswerId);

        return surveyField;
    }

    private List<Long> getChosenAnswerIdList(Long userId){
        List<Long> chosenAnswerIdList = new ArrayList<>();

        List<SurveyAnswersTable> chosenAnswerTables = getChosenByUserAnswerList(userId);

        for (SurveyAnswersTable chosenAnswerTable: chosenAnswerTables){
            chosenAnswerIdList.add(chosenAnswerTable.getId());
        }

        return chosenAnswerIdList;
    }

    private List<SurveyAnswersTable> getChosenByUserAnswerList(Long userId){
        // get user by userId and find all answers chosen by him (from survey_user_chosen_answers
        MyUserTable user = userRepository.findAllById(userId);
        List<MyUserTable> users = new ArrayList<>();
        users.add(user);
        List<SurveyAnswersTable> chosenAnswerTables = answersRepository.getAllByUsersList(users);

        return chosenAnswerTables;
    }

    private List<String> getAnswersForQuestion(List<SurveyAnswersTable> answerTables, Long questionId){
        List<String> answers = new ArrayList<>();

        for (int i=0; i< answerTables.size(); i++) {
            String answer = answerTables.get(i).getAnswer();
            answers.add(answer);
        }

        return answers;
    }

    private int getChosenAnswerIndex( List<SurveyAnswersTable> answerTables, Long userId ){
        int chosenAnswerIndex = 0;

        List<Long> chosenAnswerIdList = getChosenAnswerIdList(Long.valueOf(userId));

        for (int i=0; i< answerTables.size(); i++) {
            Long answerId = answerTables.get(i).getId();

            if (chosenAnswerIdList.contains(answerId)) {
                chosenAnswerIndex = i;
            }
        }

        return chosenAnswerIndex;
    }

    private Long getChosenAnswerIdForGivenQuestionByUser(SurveyQuestionsTable questionTable, String userId){
        Long chosenAnswerId = 0L;
        List<Long> allChosenAnswersId = new ArrayList<>();

        List<SurveyAnswersTable> answersForGivenQuestion = answersRepository.getAllByQuestion(questionTable);
        List<SurveyAnswersTable> answersChosenByUser = getChosenByUserAnswerList(Long.valueOf(userId));

        for (SurveyAnswersTable answer:  answersChosenByUser) {
            Long answerId = answer.getId();
            allChosenAnswersId.add(answerId);
        }

        for (SurveyAnswersTable answer:  answersForGivenQuestion) {
            Long answerId = answer.getId();
            if (allChosenAnswersId.contains(answerId)){
                chosenAnswerId = answerId;
                return chosenAnswerId;
            }
        }
        return chosenAnswerId;
    }
}
