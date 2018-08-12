package com.winkle.Niteleague.controller;


import com.winkle.Niteleague.model.User;
import com.winkle.Niteleague.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    UserRepository userRepository;


}
