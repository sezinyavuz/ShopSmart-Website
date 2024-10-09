package com.untitled.rrss.rest;

import com.untitled.rrss.dto.LoginRequest;
import com.untitled.rrss.entity.Question;
import com.untitled.rrss.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService theQuestionService) {
        questionService = theQuestionService;
    }

    @GetMapping("/question")
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/question/{questionId}")
    public Question findById(@PathVariable int questionId) {return questionService.findById(questionId);}

    @PostMapping("/question")
    public Question addQuestion(@RequestBody Question theQuestion) {

        theQuestion.setId(0);

        Question dbQuestion = questionService.save(theQuestion);
        return dbQuestion;
    }

    @PutMapping("/question")
    public Question updateQuestion(@RequestBody Question theQuestion) {


        Question dbQuestion = questionService.save(theQuestion);
        return dbQuestion;
    }
}