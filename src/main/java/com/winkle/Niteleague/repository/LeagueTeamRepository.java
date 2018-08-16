package com.winkle.Niteleague.repository;


import com.winkle.Niteleague.model.LeagueTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueTeamRepository extends JpaRepository<LeagueTeam, Long> {

}
