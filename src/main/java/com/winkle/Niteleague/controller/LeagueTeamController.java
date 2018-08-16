package com.winkle.Niteleague.controller;
import com.winkle.Niteleague.model.LeagueTeam;
import com.winkle.Niteleague.repository.LeagueTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeagueTeamController {

    final
    private LeagueTeamRepository leagueTeamRepository;

    @Autowired
    public LeagueTeamController(LeagueTeamRepository leagueTeamRepository) {
        this.leagueTeamRepository = leagueTeamRepository;
    }

    @GetMapping("/leagueTeams")
    public List<LeagueTeam> getAllLeagueTeams() {
        return leagueTeamRepository.findAll();
    }

    //    @GetMapping("/users/{username}")
//    public League getLeagueByUsername(@Param("leagueName") @PathVariable String leagueName) {
//        return leagueRepository.findByLeaguename(leaguename);
//    }
    @PostMapping("/createLeagueTeam")
    public LeagueTeam createLeagueTeam(LeagueTeam leagueTeam) {
        return leagueTeamRepository.save(leagueTeam);
    }
}