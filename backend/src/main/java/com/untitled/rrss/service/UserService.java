package com.untitled.rrss.service;

import com.untitled.rrss.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);

    Optional<User> authenticate(String email, String password);

    User updateUserByName(String firstName, String lastName, User updatedUser);

}
