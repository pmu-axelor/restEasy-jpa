package com.resteasyjpa.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Provider;
import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.resteasyjpa.entity.Category;
import com.resteasyjpa.entity.Expenses;

public class ServiceClas {
     
	 DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	 
	@Inject
	 Provider<EntityManager> em;
	
	@Transactional
	 public void createExpenses(int amount ,String dateField) throws ParseException {
		  Date date = df.parse(dateField);
		  
		  Expenses ex = new Expenses();
		  ex.setAmount(amount);
		  ex.setDate(date);
			
			
		em.get().persist(ex);	
	 }
	
	@Transactional
	public void deleteDetails(Long id) {
		Expenses ex =em.get().find(Expenses.class,id);
		em.get().remove(ex);
	}
    
	@Transactional
	public void createCategory(String name) {
		Category cat = new Category();
		cat.setName(name);
		em.get().persist(cat); 
		
	}
	}


