package com.example.api_final.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_final.entities.Usuario;



@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    // Since email is unique, we'll find users by email
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findById(Long id);
    Boolean existsByEmail(String email);
}
