package com.ensate.controller;

import java.util.List;

import com.ensate.entity.Lien;
import com.ensate.service.LienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.ensate.entity.Lien;
import com.ensate.repo.LienRepo;



@RestController
@RequestMapping("/lien")
public class LienController {

	@Autowired
	LienService service;

	@GetMapping("/admin/show")
	public ResponseEntity<List<Lien>> getAllLien() {
		List<Lien> list = service.getAllLien();
		return new ResponseEntity<List<Lien>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/user/show")
	public ResponseEntity<List<Lien>> getUserLien() {
		List<Lien> list = service.getUserLien();
		return new ResponseEntity<List<Lien>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/admin/add")
	public ResponseEntity<Lien> createOrUpdateLien(@RequestBody Lien entiteLien){
		Lien updated = service.createOrUpdateLien(entiteLien);
		return new ResponseEntity<Lien>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<Lien> getLienById(@PathVariable("id") Integer id) {
		Lien entity = service.getLienById(id);

		return new ResponseEntity<Lien>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/admin/{id}")
	public HttpStatus deleteLienById(@PathVariable("id") Integer id) {
		service.deleteLienById(id);
		return HttpStatus.FORBIDDEN;
	}
}
