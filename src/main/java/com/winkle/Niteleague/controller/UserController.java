package com.winkle.Niteleague.controller;


import com.winkle.Niteleague.exception.ResourceNotFoundException;
import com.winkle.Niteleague.model.User;
import com.winkle.Niteleague.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedQuery;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    final
    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@Param("username") @PathVariable String username) {
        return userRepository.findByUsername(username);
    }
    @PostMapping("/register")
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
