package com.ensate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ensate.entity.Cours;
import com.ensate.repo.CoursRepo;

@Service
public class CoursService {
	private static final Cours Excepetion = null;
	@Autowired
	CoursRepo repository;
	public List<Cours> getAllCours()
    {
        List<Cours> coursList = repository.findAll();
         
        if(coursList.size() > 0) {
            return coursList;
        } else {
            return new ArrayList<Cours>();
        }
    }
	
	
	
	public List<Cours> getUserCours()
    {
        List<Cours> coursList = repository.findByActiveTrue();
         
        if(coursList.size() > 0) {
            return coursList;
        } else {
            return new ArrayList<Cours>();
        }
    }
     
	//avoir un cours a partir de Id
    public Cours getCoursById(Integer id)
    {
        Optional<Cours> cours = repository.findById(id);
         
        if(cours.isPresent()) {
            return cours.get();
        }
		return null; 
    }
     
    //creation ou modification d un cours
    public Cours createOrUpdateCours(Cours entiteCours)  
    {
        Optional<Cours> cours = repository.findById(entiteCours.getId());
         
        if(cours.isPresent()) 
        {
            Cours newCours = cours.get();
            newCours.setTitre(entiteCours.getTitre());
            newCours.setDesc(entiteCours.getDesc());
            newCours.setLien_cours(entiteCours.getLien_cours());
            newCours.setStatus(entiteCours.isStatus());
            newCours = repository.save(newCours);
             
            return newCours;
        } else {
        	entiteCours = repository.save(entiteCours);
             
            return entiteCours;
        }
    } 
     
    //historisation d un Cours a partir de L Id
    public Cours deleteCoursById(Integer id) 
    {
        Optional<Cours> cours = repository.findById(id);
         
        if(cours.isPresent()) 
        {
        	Cours newCours = cours.get();
        	newCours.setStatus(false);
        	newCours = repository.save(newCours);
        	 return newCours;
        }
       return Excepetion ;
    } 

}
