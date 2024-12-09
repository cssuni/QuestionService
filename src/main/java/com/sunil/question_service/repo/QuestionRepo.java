package com.sunil.question_service.repo;

import com.sunil.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {


    List<Question> findByCategory(String cat);

    @Query(value = "SELECT * FROM question_two q " +
            "where q.category=:category " +
            "ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
