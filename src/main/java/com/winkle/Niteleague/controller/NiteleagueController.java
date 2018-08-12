package com.winkle.Niteleague.controller;


import com.winkle.Niteleague.exception.ResourceNotFoundException;
import com.winkle.Niteleague.model.NiteleagueUser;
import com.winkle.Niteleague.repository.NiteleagueUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class NiteleagueController {

    @Autowired
    NiteleagueUserRepository niteleagueUserRepository;

    @GetMapping("/users")
    public List<NiteleagueUser> getAllNiteleagueUsers() {
        return niteleagueUserRepository.findAll();
    }

}
