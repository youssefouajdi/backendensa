package com.ensate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensate.entity.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {
	

}
