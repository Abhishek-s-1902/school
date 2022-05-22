package com.demo.edu.school.db.jdbc.rowmapper;

import java.util.HashMap;
import java.util.Map;

import com.demo.edu.school.model.Registration;

public class RegistrationParamMapper implements ParameterMapper<Registration>{

	@Override
	public Map<String, Object> getMap(Registration obj) {
		Map<String,Object> map = new HashMap<>();
		map.put("studentid", obj.getStudentId());
		map.put("courseid", obj.getCourseId());
		return map;
	}
	
}
