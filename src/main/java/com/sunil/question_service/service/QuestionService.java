package com.sunil.question_service.service;


import com.sunil.question_service.model.Question;
import com.sunil.question_service.model.QuestionWrapper;
import com.sunil.question_service.model.Response;
import com.sunil.question_service.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo repo;


    public List<Question> allQuestion() {

        return repo.findAll();
    }

    public List<Question> getByCategory(String cat) {

        return repo.findByCategory(cat);
    }


    public void addQuestion(Question question) {
        repo.save(question);
    }

    public void deleteAll(){
        repo.deleteAll();
    }

    public ResponseEntity<List<Integer>> generateQuestions(String category, int numQ) {

        List<Question> questions = repo.findRandomQuestionsByCategory(category,numQ);

        List<Integer> ids = new ArrayList<>();

        for(Question question:questions){
            ids.add(question.getId());
        }
        return new ResponseEntity<>(ids, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(List<Integer> ids) {

        Optional<Question> question;
        List<QuestionWrapper> questionsList = new ArrayList<>();

        for(int id:ids){
           question = repo.findById(id);
           QuestionWrapper qw = new QuestionWrapper();
           qw.setId(question.get().getId());
           qw.setQuestion(question.get().getQuestion());
           qw.setOption1(question.get().getOption1());
           qw.setOption2(question.get().getOption2());
           qw.setOption3(question.get().getOption3());
           qw.setOption4(question.get().getOption4());
           questionsList.add(qw);
        }


        return new ResponseEntity<>(questionsList,HttpStatus.CREATED);

    }

    public ResponseEntity<Integer> calculateScore(List<Response> responses) {

        Optional<Question> question;
        int score = 0;

        for(Response response:responses){
            question = repo.findById(response.getId());
            if(Objects.equals(question.get().getAnswer(), response.getAnswer())){
                score++;
            }
        }
        return new ResponseEntity<>(score,HttpStatus.CREATED);

    }
}
