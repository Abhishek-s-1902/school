package com.demo.edu.school.model;

public class StudentCourse {

	Student student;
	Course course;
	
	StudentCourse(Student student, Course course) {
		this.student = student;
		this.course = course;
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
	
	//need to add hashcode
}
