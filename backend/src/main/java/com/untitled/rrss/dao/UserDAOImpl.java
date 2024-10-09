package com.untitled.rrss.dao;

import com.untitled.rrss.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO{

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl (EntityManager theEntityManager) {
        entityManager = theEntityManager;

    }
    @Override
    public List<User> findAll() {

        TypedQuery<User> theQuery = entityManager.createQuery("FROM User", User.class);

        List<User> users = theQuery.getResultList();

        return users;
    }

    @Override
    public User findById(int theId) {
        User user = entityManager.find(User.class, theId);
        return user;
    }

    @Override
    public User save(User theUser) {

        User dbUser = entityManager.merge(theUser);

        return dbUser;
    }

    @Override
    public void deleteById(int theId) {

        User theUser = entityManager.find(User.class, theId);

        entityManager.remove(theUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findByFirstNameAndLastName(String firstName, String lastName) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.firstName = :firstName AND u.lastName = :lastName", User.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }


}
