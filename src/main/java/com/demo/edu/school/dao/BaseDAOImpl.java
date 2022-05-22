package com.demo.edu.school.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class BaseDAOImpl<K,T> implements BaseDAO<K,T> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	protected final String GET_OBJECT = "SELECT * FROM %s WHERE %s =?";
	protected final String DELETE_OBJECT = "DELETE FROM %s WHERE %s =?";
	protected String table;
	protected String keyCol;
	protected RowMapper<T> rowMapper;
	protected SimpleJdbcInsert simpleJdbcTemplate;
	
	
	protected BaseDAOImpl(String table,String keyCol,RowMapper<T> rowMapper) {
		this.table = table;
		this.keyCol = keyCol;
		this.rowMapper = rowMapper;
		simpleJdbcTemplate = new SimpleJdbcInsert(jdbcTemplate);
	}
	
	@Override
	public T get(K id) {
		return (T) jdbcTemplate.queryForObject(String.format(GET_OBJECT, table, keyCol), new Object[]{id}, rowMapper);
    }
	
	@Override
	public int insert(T obj, Map<String, Object> parameters) {
		return simpleJdbcTemplate.execute(parameters);
    }

	@Override
	public int delete(K id) {
		return jdbcTemplate.update(DELETE_OBJECT,new Object[]{id});
    }


}
