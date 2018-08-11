package com.winkle.Niteleague.controller;


import com.winkle.Niteleague.exception.ResourceNotFoundException;
import com.winkle.Niteleague.model.NiteleagueUser;
import com.winkle.Niteleague.repository.NiteleagueUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.winkle.Niteleague.model.Note;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    NiteleagueUserRepository niteleagueUserRepository;

    @PostMapping("/register")
    public NiteleagueUser createUser(NiteleagueUser user) {
        return niteleagueUserRepository.save(user);
    }
}
