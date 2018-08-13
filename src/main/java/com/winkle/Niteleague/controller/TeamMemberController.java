package com.winkle.Niteleague.controller;
import com.winkle.Niteleague.model.TeamMember;
import com.winkle.Niteleague.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamMemberController {

    final
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    public TeamMemberController(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    @GetMapping("/teamMembers")
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }

    //    @GetMapping("/users/{username}")
//    public Team getTeamByUsername(@Param("teamName") @PathVariable String teamName) {
//        return teamRepository.findByTeamname(teamname);
//    }
    @PostMapping("/createTeamMember")
    public TeamMember createTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }
}