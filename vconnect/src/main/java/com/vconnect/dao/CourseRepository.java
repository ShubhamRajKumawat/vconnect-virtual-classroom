package com.vconnect.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vconnect.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
	public List<Course> findByStatus(boolean status); // find list of courses by status.

	public List<Course> findAllByName(String name); // find list of courses by name
}
