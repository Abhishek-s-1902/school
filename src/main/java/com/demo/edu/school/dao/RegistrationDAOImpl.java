package com.demo.edu.school.dao;

import com.demo.edu.school.db.jdbc.rowmapper.RegistrationRowMapper;
import com.demo.edu.school.model.Registration;

public class RegistrationDAOImpl extends BaseDAOImpl<String, Registration> {

	private final String GET_REGISTRATION = "SELECT * from Registration WHERE studentid=? and courseid=?";
	private final String DELETE_REGISTRATION = "DELETE FROM %s WHERE studentid=? and courseid=?";

	protected RegistrationDAOImpl() {
		super("Registration", null, new RegistrationRowMapper());
	}

	@Override
	public Registration get(String id) {
		return (Registration) jdbcTemplate.queryForObject(GET_REGISTRATION, new Object[]{id.split("_")}, rowMapper);
    }
	
	public int deleteStudent(String query, String studentId) {
		return jdbcTemplate.update(query, studentId);
	}
	
	@Override
	public int delete(String id) {
		return jdbcTemplate.update(DELETE_REGISTRATION,new Object[]{id.split("_")});
    }
}
