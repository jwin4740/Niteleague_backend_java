package com.winkle.Niteleague.controller;

import com.winkle.Niteleague.model.Team;
import com.winkle.Niteleague.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @GetMapping("/teams/{id}")
    public Team getTeamByTeamname(@Param("id") @PathVariable long id) {
        return teamRepository.findByTeamId(id);
    }
    @PostMapping("/createTeam")
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }
}
