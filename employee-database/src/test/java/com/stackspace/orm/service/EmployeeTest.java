package com.stackspace.orm.service;

import java.io.Serializable;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.stackspace.orm.dao.EmployeeDao;
import com.stackspace.orm.entity.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeTest {
	@InjectMocks
	private EmployeeService employeeService;
	@Mock
	private EmployeeDao<Employee, Serializable> employeeDao;
}
