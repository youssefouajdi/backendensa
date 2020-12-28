package com.ensate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ensate.entity.Lien;
import com.ensate.repo.LienRepo;

@Service
public class LienService {
	private static final Lien Excepetion = null;
	@Autowired
	LienRepo repository;
	
	//avoir tous les liens
	public List<Lien> getAllLien()
    {
        List<Lien> lienList = repository.findAll();
        if(lienList.size() > 0) {
            return lienList;
        } else {
            return new ArrayList<Lien>();
        }
    }
	
	//avoir les liens visibles que pour les visiteurs
	public List<Lien> getUserLien()
    {
        List<Lien> LienList = repository.findByActiveTrue();
        if(LienList.size() > 0) {
            return LienList;
        } else {
            return new ArrayList<Lien>();
        }
    }
     
	//avoir un lien a partir de Id
    public Lien getLienById(Integer id)
    {
        Optional<Lien> lien = repository.findById(id);
         
        if(lien.isPresent()) {
            return lien.get();
        }
		return null; 
    }
     
    //creation ou modification d un lien
    public Lien createOrUpdateLien(Lien entiteLien)  
    {
        Optional<Lien> lien = repository.findById(entiteLien.getId());
         
        if(lien.isPresent()) 
        {
            Lien newLien = lien.get();
            newLien.setTitre(entiteLien.getTitre());
            newLien.setDesc(entiteLien.getDesc());
            newLien.setLien_lien(entiteLien.getLien_lien());
            newLien.setStatus(entiteLien.isStatus());
            newLien = repository.save(newLien);
             
            return newLien;
        } else {
        	entiteLien = repository.save(entiteLien);
             
            return entiteLien;
        }
    } 
     
    //historisation d un lien a partir de L Id
    public Lien deleteLienById(Integer id) 
    {
        Optional<Lien> lien = repository.findById(id);
         
        if(lien.isPresent()) 
        {
        	Lien newLien = lien.get();
        	newLien.setStatus(false);
        	newLien = repository.save(newLien);
        	 return newLien;
        }
       return Excepetion ;
    } 

	
}
