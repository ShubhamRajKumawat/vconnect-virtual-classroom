package com.vconnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private boolean status;

	@ManyToOne // Mapping many students to one subscription
	private Student student;
	@ManyToOne
	private Course course;

	public Subscription() {// default constructor
	}

	public Subscription(boolean status, Student student, Course course) {// field constructor
		this.status = status;
		this.student = student;
		this.course = course;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
