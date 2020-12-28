package com.ensate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ensate.entity.Lien;
import com.ensate.repo.LienRepo;



@RestController
@RequestMapping("/lien")
public class LienController {
	
	@Autowired
	LienRepo lienRepo;
	
	@PostMapping("/admin/add")
	public Lien createLien (@RequestBody Lien lien) {
		return lienRepo.save(lien);
	}
	@GetMapping("/admin/show")
	public List<Lien> ListeLienAdmin(){
		return lienRepo.findAll();
	}
	
	@GetMapping("/user/show")
	
	public List<Lien> ListeLien(){
		return lienRepo.findByActiveTrue();
	}

}
