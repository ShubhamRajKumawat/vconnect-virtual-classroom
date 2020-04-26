package com.vconnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // value of ID will be auto incrementing.
	private int id;
	private String name;
	private String instructorName;
	private float duration;
	private float rating;
	private float price;
	private boolean status;

	@ManyToOne
	private Category catagory;

	public Course() {// default constructor
	}

	public Course(String name, String instructorName, float duration, float rating, float price, boolean status,
			Category catagory) { // field constructor
		this.name = name;
		this.instructorName = instructorName;
		this.duration = duration;
		this.rating = rating;
		this.price = price;
		this.status = status;
		this.catagory = catagory;
	}

	// Getters and setters
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

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		if (duration > 0.0)
			this.duration = duration;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		if (rating > 1.0)
			this.rating = rating;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if (price > 1.0)
			this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Category getCatagory() {
		return catagory;
	}

	public void setCatagory(Category catagory) {
		this.catagory = catagory;
	}

}