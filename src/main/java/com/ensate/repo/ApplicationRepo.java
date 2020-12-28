package com.ensate.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ensate.entity.Application;



public interface ApplicationRepo extends JpaRepository<Application, Integer> {
	@Query("select c from Application c where c.active =1")
	List<Application> findByActiveTrue();

}
