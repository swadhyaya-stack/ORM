package com.stackspace.orm.service;

import java.io.Serializable;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.stackspace.orm.dao.DepartmentDao;
import com.stackspace.orm.entity.Department;

@ExtendWith(MockitoExtension.class)
public class DepartmentTest {
	@InjectMocks
	private DepartmentService departmentService;
	@Mock
	private DepartmentDao<Department, Serializable> departmentDao;
}
