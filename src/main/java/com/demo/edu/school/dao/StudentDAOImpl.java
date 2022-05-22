package com.demo.edu.school.dao;

import java.util.List;

import com.demo.edu.school.db.jdbc.rowmapper.StudentRowMapper;
import com.demo.edu.school.model.Student;

public class StudentDAOImpl extends BaseDAOImpl<String, Student> {

	protected StudentDAOImpl() {
		super("Student", "id", new StudentRowMapper());
	}

	public List<Student> getStudentByCourseName(String query, String courseName) {
		return jdbcTemplate.query(query, new StudentRowMapper(), courseName);
	}
}
