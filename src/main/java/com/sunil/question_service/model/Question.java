package com.sunil.question_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class Question {

    @Id
    private int id;
    private String category;
    private String difficult;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

    @Override
    public String toString() {
        return "QuestionTwo{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", difficult='" + difficult + '\'' +
                ", question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
