package com.resteasyjpa.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.inject.Provider;
import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.resteasyjpa.entity.Expenses;

public class ServiceClas {
     
	@Inject
	 Provider<EntityManager> em;
	
	@Transactional
	 public void createExpenses(Expenses expenses) {
		  Expenses ex = new Expenses();
			ex.setAmount(expenses.getAmount());	  
			ex.setDate(expenses.getDate());
			
		em.get().persist(ex);	
	 }
	
	@Transactional
	public void deleteDetails(Long id) {
		Expenses ex =em.get().find(Expenses.class,id);
		em.get().remove(ex);
	}
	
	public Date getDateFromString(String dateString) throws ParseException {
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = df.parse(dateString);
	        return date;  
	    } 
	}


