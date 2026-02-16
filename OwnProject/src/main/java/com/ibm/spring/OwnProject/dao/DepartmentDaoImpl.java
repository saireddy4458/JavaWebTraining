package com.ibm.spring.OwnProject.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.spring.OwnProject.mapper.DepartmentRowMapper;
import com.ibm.spring.OwnProject.model.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	private final JdbcTemplate jdbcTemplate;

	public DepartmentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int save(Department d) {
		return jdbcTemplate.update("INSERT INTO department(name) VALUES (?)", d.getName());
	}

	public int update(Department d) {
		return jdbcTemplate.update("UPDATE department SET name=? WHERE id=?", d.getName(), d.getId());
	}

	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM department WHERE id=?", id);
	}

	public Department findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM department WHERE id=?", new DepartmentRowMapper(), id);
	}

	public List<Department> findAll() {
		return jdbcTemplate.query("SELECT * FROM department", new DepartmentRowMapper());
	}
}
