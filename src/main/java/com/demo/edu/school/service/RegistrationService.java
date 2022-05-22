package com.demo.edu.school.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.edu.school.dao.RegistrationDAOImpl;
import com.demo.edu.school.db.jdbc.rowmapper.RegistrationParamMapper;
import com.demo.edu.school.model.Registration;
import com.demo.edu.school.model.StudentCourse;

public class RegistrationService {

	
	@Autowired 
	RegistrationDAOImpl registrationDAO;	 
	
	public Registration get(String id) {
		return registrationDAO.get(id);
    }
	
	public int insert(Registration registration) {
		return registrationDAO.insert(registration, new RegistrationParamMapper().getMap(registration));
    }

	public int insertByStudentController(StudentCourse studentCourse) {
		Registration registration = new Registration(studentCourse.getStudent().getId(), studentCourse.getCourse().getId());
		return insert(registration);
    }
	
	public int delete(String id) {
		return registrationDAO.delete(id);
    }
	
	public int deleteStudentRegistration(String studentId) {
		String query = "DELETE from \r\n"
				+ "Registration \r\n"
				+ "WHERE StudentId=?";
		return registrationDAO.deleteStudent(query, studentId);
	}
}
