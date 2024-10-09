package com.untitled.rrss.service;

import com.untitled.rrss.dao.UserDAO;
import com.untitled.rrss.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO theUserDAO) {
        userDAO = theUserDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(int theId) {
        return userDAO.findById(theId);
    }

    @Transactional
    @Override
    public User save(User theUser) {
        return userDAO.save(theUser);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        userDAO.deleteById(theId);
    }

    public Optional<User> authenticate(String email, String password) {
        Optional<User> userOptional = userDAO.findByEmail(email);

        // Check if an Optional user is present and if the password matches
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return userOptional; // User found and password matches
        }
        return Optional.empty(); // User not found or password does not match
    }

    @Transactional
    public User updateUserByName(String firstName, String lastName, User updatedUser) {
        List<User> users = userDAO.findByFirstNameAndLastName(firstName, lastName);
        if (!users.isEmpty()) {
            User user = users.get(0); // Assuming the first match should be updated
            user.setEmail(updatedUser.getEmail());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            // Update other fields as necessary
            return userDAO.save(user);
        } else {
            throw new RuntimeException("User not found with first name " + firstName + " and last name " + lastName);
        }
    }





}
