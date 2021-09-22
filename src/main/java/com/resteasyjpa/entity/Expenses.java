package com.resteasyjpa.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.ws.rs.WebApplicationException;

import org.hibernate.type.LocalDateType;


@Entity
public class Expenses {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int amount;
	private Date date;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Expenses(Long id, int amount, Date date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
	}
	
	public Expenses() {
		super();
	}
	@Override
	public String toString() {
		return "Expenses [date=" + date + "]";
	}
}
