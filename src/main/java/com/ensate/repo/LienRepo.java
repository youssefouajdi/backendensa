package com.ensate.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ensate.entity.Lien;

public interface LienRepo extends JpaRepository<Lien, Integer> {
	@Query("select c from Lien c where c.active =1")
	List<Lien> findByActiveTrue();

}
