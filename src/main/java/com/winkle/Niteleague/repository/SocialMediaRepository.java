package com.winkle.Niteleague.repository;

import com.winkle.Niteleague.model.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {

}
