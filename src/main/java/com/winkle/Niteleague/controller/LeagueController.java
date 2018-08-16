package com.winkle.Niteleague.controller;

import com.winkle.Niteleague.model.League;
import com.winkle.Niteleague.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeagueController {

    final
    private LeagueRepository leagueRepository;

    @Autowired
    public LeagueController(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    //    @GetMapping("/users/{username}")
//    public League getLeagueByUsername(@Param("leagueName") @PathVariable String leagueName) {
//        return leagueRepository.findByLeaguename(leaguename);
//    }
    @PostMapping("/createLeague")
    public League createLeague(League league) {
        return leagueRepository.save(league);
    }
}
