package com.untitled.rrss.rest;

import com.untitled.rrss.dto.LoginRequest;
import com.untitled.rrss.entity.Answer;
import com.untitled.rrss.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AnswerController {

    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService theAnswerService) {
        answerService = theAnswerService;
    }

    @GetMapping("/answer")
    public List<Answer> findAll() {
        return answerService.findAll();
    }

    @GetMapping("/answer/{answerId}")
    public Answer findById(@PathVariable int answerId) {return answerService.findById(answerId);}

    @PostMapping("/answer")
    public Answer addAnswer(@RequestBody Answer theAnswer) {

        theAnswer.setId(0);

        Answer dbAnswer = answerService.save(theAnswer);
        return dbAnswer;
    }

    @PutMapping("/answer")
    public Answer updateQuestion(@RequestBody Answer theAnswer) {


        Answer dbAnswer = answerService.save(theAnswer);
        return dbAnswer;
    }
}