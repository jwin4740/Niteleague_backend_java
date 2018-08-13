package com.winkle.Niteleague.controller;

import com.winkle.Niteleague.model.Team;
import com.winkle.Niteleague.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamController {

    final
    private TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    //    @GetMapping("/users/{username}")
//    public Team getTeamByUsername(@Param("teamName") @PathVariable String teamName) {
//        return teamRepository.findByTeamname(teamname);
//    }
    @PostMapping("/createTeam")
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }
}
