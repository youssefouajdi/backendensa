package com.ensate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ensate.entity.Utilisateur;
import com.ensate.repo.UtilisateurRepo;

@Service
public class UtilisateurService {

	@Autowired
	UtilisateurRepo repository;
	public List<Utilisateur> getAllUtilisateurs()
    {
        List<Utilisateur> utilisateurList = repository.findAll();
         return utilisateurList;
      
    }
     
    public Utilisateur getUtilisateurById(Integer id)
    {
        Optional<Utilisateur> user = repository.findById(id);
         
        if(user.isPresent()) {
            return user.get();
        }
		return null; 
    }
     
    public Utilisateur createOrUpdateUtilisateur(Utilisateur entiteUser)  
    {
        	return repository.save(entiteUser);
    } 
     
    public Utilisateur deleteUserById(Integer id) 
    {
        Optional<Utilisateur> user = repository.findById(id);
         
        if(user.isPresent()) 
        {
        	Utilisateur newUser = user.get();
        	newUser.setEtat("USER");
        	 newUser = repository.save(newUser);
        	 return newUser;
        }
       return null;
    } 
    
}
