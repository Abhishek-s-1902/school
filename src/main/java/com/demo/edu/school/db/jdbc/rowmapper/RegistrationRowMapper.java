package com.demo.edu.school.db.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.edu.school.model.Registration;

public class RegistrationRowMapper implements RowMapper<Registration> {

	@Override
	public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
		Registration registration = new Registration();
		registration.setStudentId(rs.getString("studentId"));
		registration.setCourseId(rs.getString("courseId"));
        return registration;
	}
}
