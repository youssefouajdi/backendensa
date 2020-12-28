package com.ensate.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ensate.entity.Cours;

@Repository
public interface CoursRepo extends JpaRepository<Cours, Integer> {
	@Query("select c from Cours c where c.active =1")
    public List<Cours> findByActiveTrue();

}
