package com.resteasyjpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expenses {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String amount;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Expenses(int id, String amount, Date date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
	}
	public Expenses() {
		super();
	}
	
	
}
