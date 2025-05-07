package com.example.project0002.repository;

import com.example.project0002.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    @Modifying
    @Query("UPDATE User u SET u.role = :role WHERE u.id = :userId")
    Optional<Boolean> updateRole(String id,String role);
}