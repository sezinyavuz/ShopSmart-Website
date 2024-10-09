package com.untitled.rrss.dao;

import com.untitled.rrss.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionDAO {
    List<Question> findAll();

    Question findById(int theId);

    Question save(Question theQuestion);

    void deleteById(int theId);
}