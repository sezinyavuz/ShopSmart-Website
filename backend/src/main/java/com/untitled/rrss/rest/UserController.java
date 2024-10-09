package com.untitled.rrss.rest;

import com.untitled.rrss.dto.LoginRequest;
import com.untitled.rrss.entity.User;
import com.untitled.rrss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/user")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable int userId) {return userService.findById(userId);}

    @PostMapping("/user")
    public User addUser(@RequestBody User theUser) {

        theUser.setId(0);

        User dbUser = userService.save(theUser);
        return dbUser;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());  // Login successful, return the user data
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @PutMapping("/user/updateByName")
    public ResponseEntity<?> updateUser(@RequestBody User theUser) {
        try {
            User updatedUser = userService.updateUserByName(theUser.getFirstName(), theUser.getLastName(), theUser);
            if (updatedUser != null) {
                return ResponseEntity.ok(updatedUser);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with given first and last name");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @DeleteMapping("/user/{userId}")
    public String deleteById(@PathVariable int userId) {

        User tempUser = userService.findById(userId);

        if (tempUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deleteById(userId);

        return "Deleted user by id - " + userId;
    }
}
