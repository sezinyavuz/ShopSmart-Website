package com.untitled.rrss.service;

import com.untitled.rrss.entity.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerService {

    List<Answer> findAll();

    Answer findById(int theId);

    Answer save(Answer theAnswer);

    void deleteById(int theId);

}