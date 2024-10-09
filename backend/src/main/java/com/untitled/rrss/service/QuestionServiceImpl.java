package com.untitled.rrss.service;

import com.untitled.rrss.dao.QuestionDAO;
import com.untitled.rrss.entity.Question;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDAO questionDAO;

    @Autowired
    public QuestionServiceImpl(QuestionDAO theQuestionDAO) {
        questionDAO = theQuestionDAO;
    }

    @Override
    public List<Question> findAll() {
        return questionDAO.findAll();
    }

    @Override
    public Question findById(int theId) {
        return questionDAO.findById(theId);
    }

    @Transactional
    @Override
    public Question save(Question theQuestion) {
        return questionDAO.save(theQuestion);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        questionDAO.deleteById(theId);
    }
}