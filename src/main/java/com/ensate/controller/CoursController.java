package com.ensate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ensate.entity.Cours;
import com.ensate.service.CoursService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/cours")
public class CoursController {
	
	@Autowired
	CoursService service;
	
	@GetMapping("/admin/show")
	public ResponseEntity<List<Cours>> getAllCours() {
	        List<Cours> list = service.getAllCours();
	        return new ResponseEntity<List<Cours>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	
	@GetMapping("/user/show")
	public ResponseEntity<List<Cours>> getUserCours() {
	        List<Cours> list = service.getUserCours();
	        return new ResponseEntity<List<Cours>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	
	    @PostMapping("/admin/add")
	    public ResponseEntity<Cours> createOrUpdateCours(@RequestBody Cours entiteCours){
	    	Cours updated = service.createOrUpdateCours(entiteCours);
	        return new ResponseEntity<Cours>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	
	    @GetMapping("/admin/{id}")
	    public ResponseEntity<Cours> getCoursById(@PathVariable("id") Integer id) {
	    	Cours entity = service.getCoursById(id);
	 
	        return new ResponseEntity<Cours>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	    
	    @PutMapping("/admin/{id}")
	    public HttpStatus deleteCoursById(@PathVariable("id") Integer id) {
	        service.deleteCoursById(id);
	        return HttpStatus.FORBIDDEN;
	    }
}
