package com.vconnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // value of ID will be auto incrementing.
	private int id;
	private String name;
	private boolean status;

	public Category() { // default constructor
	}

	public Category(String name, boolean status) { // field constructor
		this.name = name;
		this.status = status;
	}

	// Getters and setters
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", status=" + status + "]";
	}

}
