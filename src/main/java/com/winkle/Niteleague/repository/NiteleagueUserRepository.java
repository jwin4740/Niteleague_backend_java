package com.winkle.Niteleague.repository;

import com.winkle.Niteleague.model.NiteleagueUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiteleagueUserRepository extends JpaRepository<NiteleagueUser, Long> {
}
