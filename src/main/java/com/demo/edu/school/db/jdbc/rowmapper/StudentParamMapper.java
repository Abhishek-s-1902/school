package com.demo.edu.school.db.jdbc.rowmapper;

import java.util.HashMap;
import java.util.Map;

import com.demo.edu.school.model.Student;

public class StudentParamMapper implements ParameterMapper<Student>{

	public Map<String,Object> getMap(Student student) {
		Map<String,Object> map = new HashMap<>();
		map.put("ID", student.getId());
		map.put("name", student.getName());
		return map;
	}
}
