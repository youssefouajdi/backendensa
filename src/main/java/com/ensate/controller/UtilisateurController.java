package com.ensate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ensate.entity.Utilisateur;
import com.ensate.service.UtilisateurService;

@RestController
@CrossOrigin(origins="http://localhost:4200") 
@RequestMapping("/utilisateur")
public class UtilisateurController {
	 @Autowired
	   UtilisateurService service;
	 
	    @GetMapping("/admin/show")
	public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
	        List<Utilisateur> list = service.getAllUtilisateurs();
	        return new ResponseEntity<List<Utilisateur>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	
	    @PostMapping("/admin/add")
	    public ResponseEntity<Utilisateur> createOrUpdateUtiliateur(@RequestBody Utilisateur entiteUser){
	    	Utilisateur updated = service.createOrUpdateUtilisateur(entiteUser);
	        return new ResponseEntity<Utilisateur>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	
	    @GetMapping("/admin/{id}")
	    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") Integer id) {
	    	Utilisateur entity = service.getUtilisateurById(id);
	 
	        return new ResponseEntity<Utilisateur>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	    @PutMapping("/admin/{id}")
	    public HttpStatus deleteUtilisateurById(@PathVariable("id") Integer id) {
	        service.deleteUserById(id);
	        return HttpStatus.FORBIDDEN;
	    }
}
