package com.citiustech.entity;

import javax.persistence.Entity;

import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="tbl_cust")
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String email;
	private LocalDate dateOfBirth;
	
	@OneToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="addr_id")
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
