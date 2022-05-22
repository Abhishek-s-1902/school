package com.demo.edu.school.db.jdbc.rowmapper;

import java.util.Map;

public interface ParameterMapper<T> {
	
	public Map<String,Object> getMap(T obj);

}
