package com.vconnect.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vconnect.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	public List<Student> findAllByName(String name);// find list of students by name.

}
