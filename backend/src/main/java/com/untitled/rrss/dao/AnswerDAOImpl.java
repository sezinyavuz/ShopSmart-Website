package com.untitled.rrss.dao;

import com.untitled.rrss.entity.Answer;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AnswerDAOImpl implements AnswerDAO {

    private EntityManager entityManager;

    @Autowired
    public AnswerDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;

    }

    @Override
    public List<Answer> findAll() {

        TypedQuery<Answer> theQuery = entityManager.createQuery("FROM Answer ", Answer.class);

        List<Answer> answers = theQuery.getResultList();

        return answers;
    }

    @Override
    public Answer findById(int theId) {
        Answer answer = entityManager.find(Answer.class, theId);
        return answer;
    }

    @Override
    public Answer save(Answer theAnswer) {

        Answer dbAnswer = entityManager.merge(theAnswer);

        return dbAnswer;
    }

    @Override
    public void deleteById(int theId) {

        Answer theAnswer = entityManager.find(Answer.class, theId);

        entityManager.remove(theAnswer);
    }
}
