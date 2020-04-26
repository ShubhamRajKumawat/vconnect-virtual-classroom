package com.vconnect.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vconnect.dao.StudentRepository;
import com.vconnect.entity.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() { // Fetch list of all students.
		List<Student> listOfStudents = new ArrayList<>();
		studentRepository.findAll().forEach(listOfStudents::add);
		return listOfStudents;
	}

	public Optional<Student> getStudentById(int id) { // Fetch student by ID.
		return studentRepository.findById(id);
	}

	public List<Student> getStudentByName(String name) { // fetch student by name
		return studentRepository.findAllByName(name);
	}

	public String addStudent(Student student) { // add student
		studentRepository.save(student);
		return "Student added";
	}

	public String updateStudent(Student student) { // update student
		studentRepository.save(student);
		return "Student Updated";
	}

	public String deleteStudent(int id) { // soft delete the student.
		Optional<Student> deleteStudentInfo = studentRepository.findById(id);
		if (deleteStudentInfo.isPresent()) {
			Student student = deleteStudentInfo.get();
			student.setStatus(true);
			studentRepository.save(student);
		}
		return "Student deleted";
	}

}
