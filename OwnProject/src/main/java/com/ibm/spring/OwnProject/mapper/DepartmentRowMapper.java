package com.ibm.spring.OwnProject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.spring.OwnProject.model.Department;

public class DepartmentRowMapper implements RowMapper<Department> {
	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department d = new Department();
		d.setId(rs.getInt("id"));
		d.setName(rs.getString("name"));
		return d;
	}
}