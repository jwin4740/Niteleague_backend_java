package com.winkle.Niteleague.repository;

import com.winkle.Niteleague.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueFormatRepository extends JpaRepository<League, Long> {

}
