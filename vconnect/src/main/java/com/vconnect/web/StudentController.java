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

import com.vconnect.entity.Student;
import com.vconnect.service.StudentService;

@CrossOrigin
@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping(value = "/student")		//fetch all registered students
	public List<Student> getStudent() {
		return studentService.getAllStudents();
	}

	@GetMapping(value = "/student/{id}")		//fetch all registered students by ID
	public Optional<Student> getStudentById(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}

	@GetMapping(value = "/student/name")		//fetch all registered students by ID
	public List<Student> getStudentByName(@RequestBody Student studentInfo) {
		return studentService.getStudentByName(studentInfo.getName());
	}

	@PostMapping(value = "/student/")		//Add student
	public String addStudentInfo(@RequestBody Student studentInfo) {
		return studentService.addStudent(studentInfo);

	}

	@PutMapping(value = "/student/{id}")	//Update student by ID.
	public String updateStudentInfo(@PathVariable("id") int id, @RequestBody Student updateInfo) {
		updateInfo.setId(id);
		return studentService.updateStudent(updateInfo);
	}

	@DeleteMapping(value = "/student/{id}")		//Delete student by ID.
	public String deleteStudentInfo(@PathVariable("id") int id) {
		return studentService.deleteStudent(id);
	}
}
