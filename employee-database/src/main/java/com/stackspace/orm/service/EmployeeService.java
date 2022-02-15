package com.stackspace.orm.service;

import java.io.Serializable;
import java.util.Iterator;

import com.stackspace.orm.dao.EmployeeDao;
import com.stackspace.orm.entity.Employee;

public class EmployeeService {
	private EmployeeDao<Employee, Serializable> employeeDao;

	public EmployeeService(EmployeeDao<Employee, Serializable> employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	public void addEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	public void editDetails(Employee employee) {
		employeeDao.update(employee);
	}

	public Employee getEmployeeById(int employeeId) {
		return employeeDao.findById(employeeId);
	}

	public Iterator<Employee> getAllEmployee() {
		Iterator<Employee> iterator = employeeDao.findAll().iterator();
		return iterator;
	}

	public void removeEmployee(Employee employee) {
		employeeDao.delete(employee);
	}
}
