package com.ensate.controller;

import java.util.List;

import com.ensate.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ensate.entity.Application;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/application")
public class ApplicationController {
	@Autowired
	ApplicationService service;
	
	@GetMapping("/admin/show")
	public ResponseEntity<List<Application>> getAllApplication() {
	        List<Application> list = service.getAllApplication();
	        return new ResponseEntity<List<Application>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	
	@GetMapping("/user/show")
	public ResponseEntity<List<Application>> getUserApplication() {
	        List<Application> list = service.getUserApplication();
	        return new ResponseEntity<List<Application>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	
	    @PostMapping("/admin/add")
	    public ResponseEntity<Application> createOrUpdateApplication(@RequestBody Application entiteApplication){
	    	Application updated = service.createOrUpdateApplication(entiteApplication);
	        return new ResponseEntity<Application>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	
	    @GetMapping("/admin/{id}")
	    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Integer id) {
	    	Application entity = service.getApplicationById(id);
	 
	        return new ResponseEntity<Application>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	    
	    @PutMapping("/admin/{id}")
	    public HttpStatus deleteApplicationById(@PathVariable("id") Integer id) {
	        service.deleteApplicationById(id);
	        return HttpStatus.FORBIDDEN;
	    }
}
