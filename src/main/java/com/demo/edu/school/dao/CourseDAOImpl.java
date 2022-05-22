package com.demo.edu.school.dao;

import com.demo.edu.school.model.Course;

public class CourseDAOImpl extends BaseDAOImpl<String, Course>{

	protected CourseDAOImpl() {
		super("Course", "id", null);
	}
	
}
