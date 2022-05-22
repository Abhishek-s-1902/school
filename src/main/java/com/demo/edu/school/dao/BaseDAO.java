package com.demo.edu.school.dao;

import java.util.Map;

public interface BaseDAO<K,T> {

	T get(K id);
	
	int insert(T obj, Map<String, Object> parameters);

	int delete(K id);
}
