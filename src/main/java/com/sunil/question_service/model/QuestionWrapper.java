package com.sunil.question_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionWrapper {

    private int id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
