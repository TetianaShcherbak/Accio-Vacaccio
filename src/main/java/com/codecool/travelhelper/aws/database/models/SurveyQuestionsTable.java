package com.codecool.travelhelper.aws.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "SurveyQuestionsTable")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SurveyQuestionsTable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", updatable = false)
    private Long Id;

    @Column(
            name = "question",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String question;

//----------------------------------------------------------------------

    // question to answers
    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private List<SurveyAnswersTable> answers = new ArrayList<>();

//----------------------------------------------------------------------

    public SurveyQuestionsTable(Long id, String question) {
        Id = id;
        this.question = question;
    }
}
