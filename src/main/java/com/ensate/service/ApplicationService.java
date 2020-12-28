package com.ensate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensate.entity.Application;
import com.ensate.repo.ApplicationRepo;
@Service
public class ApplicationService {
	private static final Application Excepetion = null;
	@Autowired
	ApplicationRepo repository;
	public List<Application> getAllApplication()
    {
        List<Application> applicationList = repository.findAll();
         
        if(applicationList.size() > 0) {
            return applicationList;
        } else {
            return new ArrayList<Application>();
        }
    }
	
	public List<Application> getUserApplication()
    {
        List<Application> applicationList = repository.findByActiveTrue();
         
        if(applicationList.size() > 0) {
            return applicationList;
        } else {
            return new ArrayList<Application>();
        }
    }
     
    public Application getApplicationById(Integer id)
    {
        Optional<Application> application = repository.findById(id);
         
        if(application.isPresent()) {
            return application.get();
        }
		return null; 
    }
     
    public Application createOrUpdateApplication(Application entiteApplication)  
    {
        Optional<Application> application = repository.findById(entiteApplication.getId());
         
        if(application.isPresent()) 
        {
            Application newApplication = application.get();
            newApplication.setTitre(entiteApplication.getTitre());
            newApplication.setDesc(entiteApplication.getDesc());
            newApplication.setLien_application(entiteApplication.getLien_application());
            newApplication.setStatus(entiteApplication.isStatus());
            newApplication = repository.save(newApplication);
             
            return newApplication;
        } else {
        	entiteApplication = repository.save(entiteApplication);
             
            return entiteApplication;
        }
    } 
     
    public Application deleteApplicationById(Integer id) 
    {
        Optional<Application> application = repository.findById(id);
         
        if(application.isPresent()) 
        {
        	Application newApplication = application.get();
        	newApplication.setStatus(false);
        	newApplication = repository.save(newApplication);
        	 return newApplication;
        }
       return Excepetion ;
    } 


}
