package com.vconnect.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vconnect.dao.CourseRepository;
import com.vconnect.entity.Course;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAllCourses() { // Get list of all courses.
		List<Course> listOfCourses = new ArrayList<>();
		courseRepository.findByStatus(false).forEach(listOfCourses::add);
		return listOfCourses;
	}

	public Optional<Course> getCourseById(int id) { // Get Course content by ID
		return courseRepository.findById(id);
	}

	public List<Course> getCourseByName(String name) { // Get course information by Name
		return courseRepository.findAllByName(name);
	}

	public boolean addCourse(Course course) { // Add course
		try {
			courseRepository.save(course);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	public String updateCourse(Course course) { // Update course
		courseRepository.save(course);
		return "Updated !";
	}

	public boolean deleteCourse(int id) { // Soft Delete course
		try {
			Optional<Course> deleteCourseInfo = courseRepository.findById(id);
			if (deleteCourseInfo.isPresent()) {
				Course course = deleteCourseInfo.get();
				course.setStatus(true);
				courseRepository.save(course);
				return true;
			}
			return false;
		}
		catch (Exception e) {
			return false;
		}
	}

	public List<Course> getAllActiveCourses() { // Fetch all active courses.
		List<Course> listOfActiveCourses = courseRepository.findByStatus(true);
		return listOfActiveCourses;

	}

	public List<Course> getAllDeletedCourses() { // Fetch all in-active courses.
		List<Course> listOfDeletedCourses = courseRepository.findByStatus(false);
		return listOfDeletedCourses;

	}

}
