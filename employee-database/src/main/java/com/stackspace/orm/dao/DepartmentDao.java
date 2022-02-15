package com.stackspace.orm.dao;

import java.io.Serializable;
import java.util.List;

import com.stackspace.orm.entity.Department;

public interface DepartmentDao<T, Id extends Serializable> {
	void save(Department department);

	void update(Department department);

	Department findById(int departmentId);

	List<Department> findAll();

	void delete(Department department);
}
