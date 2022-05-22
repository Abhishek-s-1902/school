package com.demo.edu.school.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.edu.school.dao.CourseDAOImpl;
import com.demo.edu.school.model.Course;


public class CourseService {

	@Autowired 
	CourseDAOImpl courseDAO;
	 
	
	public Course get(String id) {
		return courseDAO.get(id);
  }
	
	public int insert(Course student) {
		return courseDAO.insert(student,null);
  }
	
	public int delete(String id) {
		return courseDAO.delete(id);
  }
}
