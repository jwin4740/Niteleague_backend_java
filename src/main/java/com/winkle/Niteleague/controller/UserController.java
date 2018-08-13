package com.winkle.Niteleague.controller;


import com.winkle.Niteleague.exception.ResourceNotFoundException;
import com.winkle.Niteleague.model.User;
import com.winkle.Niteleague.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedQuery;
import javax.validation.Valid;
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

    @PutMapping("/users/{username}")
    public User updateUser(String username, User userDetails) {

        User user = userRepository.findByUsername(username);

        user.setUsername(userDetails.getUsername());
        user.setTwitter(userDetails.getTwitter());
        user.setDOB(userDetails.getDOB());
        user.setPSN(userDetails.getPSN());
        user.setEpicGames(userDetails.getEpicGames());
        user.setXbox(userDetails.getXbox());
        user.setYoutube(userDetails.getYoutube());
        user.setInstagram(userDetails.getInstagram());
        user.setStream(userDetails.getStream());
        user.setEmailAddress(userDetails.getEmailAddress());
        user.setAvatar(userDetails.getAvatar());
        user.setName(userDetails.getName());


        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
