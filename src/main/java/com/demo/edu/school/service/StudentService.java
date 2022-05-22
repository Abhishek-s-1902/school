package com.demo.edu.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.edu.school.dao.StudentDAOImpl;
import com.demo.edu.school.db.jdbc.rowmapper.StudentParamMapper;
import com.demo.edu.school.model.Student;

public class StudentService {

	 @Autowired 
	 StudentDAOImpl studentDAO;
	 
	
	public Student get(String id) {
		return studentDAO.get(id);
   }
	
	public int insert(Student student) {
		return studentDAO.insert(student, new StudentParamMapper().getMap(student));
   }
	
	public int delete(String id) {
		return studentDAO.delete(id);
   }
	
	public List<Student> getStudentByCourseId(String courseName) {
		String query = "SELECT * \r\n"
				+ "FROM Student s\r\n"
				+ "Join Registration r ON\r\n"
				+ "s.id = r.studentid\r\n"
				+ "Join course ON\r\n"
				+ "(c.id = r.courseid \r\n"
				+ "AND c.courseName = ?)\r\n"
				+ "ORDER BY name ASC";
		return studentDAO.getStudentByCourseName(query, courseName);
	}
}
