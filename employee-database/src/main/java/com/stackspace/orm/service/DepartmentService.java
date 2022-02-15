package com.stackspace.orm.service;

import java.io.Serializable;
import java.util.Iterator;

import com.stackspace.orm.dao.DepartmentDao;
import com.stackspace.orm.entity.Department;

public class DepartmentService {
	private DepartmentDao<Department, Serializable> departmentDao;

	public DepartmentService(DepartmentDao<Department, Serializable> departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	public void addDepartment(Department department) {
		departmentDao.save(department);
	}

	public void editDepartment(Department department) {
		departmentDao.update(department);
	}

	public void removeDepartment(Department department) {
		departmentDao.delete(department);
	}

	public Iterator<Department> getAllDepartment() {
		return departmentDao.findAll().iterator();
	}

	public Department getDepartment(int departmentId) {
		return departmentDao.findById(departmentId);
	}
}
