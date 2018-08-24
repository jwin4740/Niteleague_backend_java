package com.winkle.Niteleague.repository;

import com.winkle.Niteleague.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT p FROM Team p where p.id = :id")
    Team findByTeamId(@Param("id") long id);

}

