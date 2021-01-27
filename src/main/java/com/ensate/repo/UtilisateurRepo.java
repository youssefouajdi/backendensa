package com.ensate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensate.entity.Utilisateur;

import java.util.Optional;


public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String userName);

}
