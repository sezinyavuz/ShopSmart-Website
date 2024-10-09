package com.untitled.rrss.service;

import com.untitled.rrss.dao.AnswerDAO;
import com.untitled.rrss.entity.Answer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerDAO answerDAO;

    @Autowired
    public AnswerServiceImpl(AnswerDAO theAnswerDAO) {
        answerDAO = theAnswerDAO;
    }

    @Override
    public List<Answer> findAll() {
        return answerDAO.findAll();
    }

    @Override
    public Answer findById(int theId) {
        return answerDAO.findById(theId);
    }

    @Transactional
    @Override
    public Answer save(Answer theAnswer) {
        return answerDAO.save(theAnswer);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        answerDAO.deleteById(theId);
    }
}