package com.winkle.Niteleague.repository;

import com.winkle.Niteleague.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT p FROM User p where p.username = :username")
    User findByUsername(@Param("username") String username);
}


