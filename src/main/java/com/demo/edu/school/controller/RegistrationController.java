package com.demo.edu.school.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.edu.school.model.Registration;
import com.demo.edu.school.model.Student;
import com.demo.edu.school.model.StudentCourse;
import com.demo.edu.school.service.CourseService;
import com.demo.edu.school.service.RegistrationService;
import com.demo.edu.school.service.StudentService;

@RestController
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	//Problem: 2.1: add a new student along with their course registrations.
	//Might have to check if the Course exist
	@PostMapping(path = "/register")
	public ResponseEntity<String> createRegistration(@Valid @RequestBody StudentCourse studentCourse) {
		Student student = studentCourse.getStudent();
		Registration registration = new Registration(student.getId(), studentCourse.getCourse().getId());
		if (studentService.insert(student)>0 &&
		registrationService.insert(registration)>0) {
			return new ResponseEntity<>(String.format("Registration completed for %s",student.getId()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(String.format("Registration incompleted for %s",student.getId()), HttpStatus.BAD_REQUEST);
		}
	}
}
