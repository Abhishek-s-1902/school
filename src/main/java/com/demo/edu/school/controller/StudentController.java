package com.demo.edu.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.edu.school.model.Student;
import com.demo.edu.school.service.RegistrationService;
import com.demo.edu.school.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	RegistrationService registrationService;
	
	//Problem 2.3).Get all students, sorted by their name, for a given course with course name as input
	@GetMapping(path = "/students")
	public List<Student> getStudentByCourseId(@RequestParam(value = "courseName") String courseName) {
		return studentService.getStudentByCourseId(courseName);
	}
	
	//Problem 2.2: Delete a student 
	@DeleteMapping(path = "/deletestudent")
	public ResponseEntity<String> deleteStudent(@RequestParam(value = "id") String id) {
		
		 if(registrationService.deleteStudentRegistration(id)>0 &&
				 studentService.delete(id)>0) {
			 return new ResponseEntity<>(String.format("Deleted student %s",id), HttpStatus.OK);
		 } else {
			 return new ResponseEntity<>(String.format("Deleted incompleted for %s",id), HttpStatus.BAD_REQUEST);
		 }
	}
	
	
}
