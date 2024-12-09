package com.sunil.question_service.controller;



import com.sunil.question_service.model.Question;
import com.sunil.question_service.model.QuestionWrapper;
import com.sunil.question_service.model.Response;
import com.sunil.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    private QuestionService service;



    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAll(){
        try {
            return new ResponseEntity<>(service.allQuestion(), HttpStatus.OK);
        } catch (Exception e) {
                e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    @GetMapping("/category/{cat}")
    public List<Question> byCategory(@PathVariable String cat){

        return service.getByCategory(cat);
    }
    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        service.addQuestion(question);
        return new ResponseEntity<>("Question Added Successfully",HttpStatus.ACCEPTED) ;
    }

    @DeleteMapping("deleteAll")
    public String deleteAll(){
        service.deleteAll();
        return "All Deleted";
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> createQuiz( @RequestParam String category,  @RequestParam  Integer numQ){

        return service.generateQuestions( category,numQ);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(@RequestBody List<Integer> ids){

        return service.getQuestionsFromIds(ids);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){

        return service.calculateScore(responses);

    }


}
