package com.untitled.rrss.dao;

import com.untitled.rrss.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);

    Optional<User> findByEmail(String email);
    List<User> findByFirstNameAndLastName(String firstName, String lastName);



}
