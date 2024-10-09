package com.untitled.rrss.dao;

import com.untitled.rrss.entity.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuestionDAOImpl implements QuestionDAO {

    private EntityManager entityManager;

    @Autowired
    public QuestionDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;

    }

    @Override
    public List<Question> findAll() {

        TypedQuery<Question> theQuery = entityManager.createQuery("FROM Question ", Question.class);

        List<Question> questions = theQuery.getResultList();

        return questions;
    }

    @Override
    public Question findById(int theId) {
        Question question = entityManager.find(Question.class, theId);
        return question;
    }

    @Override
    public Question save(Question theQuestion) {

        Question dbQuestion = entityManager.merge(theQuestion);

        return dbQuestion;
    }

    @Override
    public void deleteById(int theId) {

        Question theQuestion = entityManager.find(Question.class, theId);

        entityManager.remove(theQuestion);
    }
}
