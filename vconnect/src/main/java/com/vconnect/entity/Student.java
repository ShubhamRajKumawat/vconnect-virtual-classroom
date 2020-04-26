package com.vconnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // value of ID will be auto incrementing.
	private int id;
	private String name;
	private String email;
	private boolean status;

	public Student() {// default constructor
	}

	public Student(String name, String email, boolean status) {// field constructor
		this.name = name;
		this.email = email;
		this.status = status;
	}

//Getters and setters
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

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

}
