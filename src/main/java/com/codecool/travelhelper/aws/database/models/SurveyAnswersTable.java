package com.codecool.travelhelper.aws.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "SurveyAnswersTable")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SurveyAnswersTable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id", updatable = false)
    private Long Id;

    @Column(
            name = "answer",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String answer;

//---------------------------------------------------

    // answers to question
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private SurveyQuestionsTable question;
//------------------------------------------------------
    // answers to user
    @ManyToMany
    @JoinTable(
            name = "survey_user_chosen_answers",
            joinColumns = @JoinColumn(name = "answer_id"),
            inverseJoinColumns = @JoinColumn( name = "user_id")
    )
    @JsonIgnore
    private List<MyUserTable> usersList = new ArrayList<>();

    public SurveyAnswersTable(Long id, String answer) {
        Id = id;
        this.answer = answer;
    }
}
