package com.vconnect.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vconnect.entity.Course;
import com.vconnect.service.CourseService;

@CrossOrigin
@RestController
public class CourseController {
	@Autowired
	CourseService courseService;

	@GetMapping(value = "/course")	//fetch all items in Course
	public List<Course> getCourse() {
		return courseService.getAllCourses();
	}

	@GetMapping(value = "/course/{id}")	//fetch all items in Course by ID.
	public Course getCourseById(@PathVariable int id) {
		return courseService.getCourseById(id).orElse(new Course());
	}

	@PostMapping(value = "/course/")		//Add items in Course
	public boolean addCourseInfo(@RequestBody Course courseInfo) {
		return courseService.addCourse(courseInfo);

	}

	@PutMapping(value = "/course/{id}")		//Update items in Course by ID.
	public String updateCourseInfo(@PathVariable("id") int id, @RequestBody Course updateInfo) {
		updateInfo.setId(id);
		return courseService.updateCourse(updateInfo);
	}

	@DeleteMapping(value = "/course/{id}")		//Delete items in Course by ID.
	public boolean deleteCourseInfo(@PathVariable("id") int id) {
		return courseService.deleteCourse(id);
	}
}