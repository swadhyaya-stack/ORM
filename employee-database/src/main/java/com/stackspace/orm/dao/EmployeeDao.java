package com.stackspace.orm.dao;

import java.io.Serializable;
import java.util.List;

import com.stackspace.orm.entity.Employee;

public interface EmployeeDao<T, Id extends Serializable> {
	void save(Employee employee);

	void update(Employee employee);

	Employee findById(int employeeId);

	List<Employee> findAll();

	void delete(Employee employee);
}
