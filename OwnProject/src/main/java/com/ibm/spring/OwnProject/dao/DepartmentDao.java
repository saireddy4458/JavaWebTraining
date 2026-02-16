package com.ibm.spring.OwnProject.dao;

import java.util.List;

import com.ibm.spring.OwnProject.model.Department;

public interface DepartmentDao {
	int save(Department d);

	int update(Department d);

	int delete(int id);

	Department findById(int id);

	List<Department> findAll();
}
