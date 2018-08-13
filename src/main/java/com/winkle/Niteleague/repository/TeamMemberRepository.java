package com.winkle.Niteleague.repository;


import com.winkle.Niteleague.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

}
