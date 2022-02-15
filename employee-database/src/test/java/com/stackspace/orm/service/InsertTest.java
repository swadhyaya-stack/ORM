package com.stackspace.orm.service;

import static org.mockito.Mockito.verify;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.stackspace.orm.dao.DepartmentDao;
import com.stackspace.orm.dao.EmployeeDao;
import com.stackspace.orm.entity.Department;
import com.stackspace.orm.entity.Employee;

@ExtendWith(MockitoExtension.class)
public class InsertTest {
	private static String[] employeesData = {
			"  68319 , KAYLING , WOGN     , MALE ,9874563210 , PRESIDENT ,            , 1991-11-18 , 6000.00 ,            ,   1001 , kayling.wogn@gmail.com",
			"  66928 , BLAZE   , SHAZAM   , MALE ,6547893210 , MANAGER   ,      68319 , 1991-05-01 , 2750.00 ,            ,   3001 , blaze.shazam@gmail.com",
			"  67832 , CLARE   ,KORTASHO  , MALE ,3210456987 , MANAGER   ,      68319 , 1991-06-09 , 2550.00 ,            ,   1001 , clare.kortasho@gmail.com",
			"  65646 , JONAS   ,FEARTH    , MALE , 7410258963, MANAGER   ,      68319 , 1991-04-02 , 2957.00 ,            ,   2001 , jonas.fearth@gmail.com",
			"  67858 , SCARLET ,MOARTIN   ,FEMALE,9632587410 , ANALYST   ,      65646 , 1997-04-19 , 3100.00 ,            ,   2001 , scarlet.moartin@gmail.com",
			"  69062 , FRANK   ,CHARLS    , MALE , 7536984120, ANALYST   ,      65646 , 1991-12-03 , 3100.00 ,            ,   2001 , frank.charls@gmail.com",
			"  63679 , SANDRINE,DOWNEY    , MALE ,6578932140 , CLERK     ,      69062 , 1990-12-18 ,  900.00 ,            ,   2001 , sandrine.downey@gmail.com",
			"  64989 , ADELYN  ,BAWEG     , MALE ,8745693210 , SALESMAN  ,      66928 , 1991-02-20 , 1700.00 ,     400.00 ,   3001 , adelyn.baweg@gmail.com",
			"  65271 , WADE    ,ATLANTIS  ,FEMALE,8965471230 , SALESMAN  ,      66928 , 1991-02-22 , 1350.00 ,     600.00 ,   3001 , wade.atlantis@gmail.com",
			"  66564 , MADDEN  ,PARKAR    , MALE ,9514782360 , SALESMAN  ,      66928 , 1991-09-28 , 1350.00 ,    1500.00 ,   3001 , madden.parkar@gmail.com",
			"  68454 , TUCKER  ,RONALDO   , MALE ,9317864250 , SALESMAN  ,      66928 , 1991-09-08 , 1600.00 ,       0.00 ,   3001 , tucker.ronaldo@gmail.com",
			"  68736 , ADNRES  ,JONSON    , MALE ,9571382640 , CLERK     ,      67858 , 1997-05-23 , 1200.00 ,            ,   2001 , adnres.jonson@gmail.com",
			"  69000 , JULIUS  ,McDONALD  ,FEMALE,8246539710 , CLERK     ,      66928 , 1991-12-03 , 1050.00 ,            ,   3001 , julius.mcdonald@gmail.com",
			"  69324 , MARKER  ,ADOM      , MALE ,7498631520 , CLERK     ,      67832 , 1992-01-23 , 1400.00 ,            ,   1001 , marker.adom@gmail.com" };
	@InjectMocks
	private EmployeeService employeeService;
	@Mock
	private EmployeeDao<Employee, Serializable> employeeDao;
	@InjectMocks
	private DepartmentService departmentService;
	@Mock
	private DepartmentDao<Department, Serializable> departmentDao;

	@Test
	public void insertDepartmentData() {
		List<Department> departmentList = new ArrayList<Department>();
		List<Employee> employeeList1 = new ArrayList<Employee>();
		List<Employee> employeeList2 = new ArrayList<Employee>();
		List<Employee> employeeList3 = new ArrayList<Employee>();

		for (String data : employeesData) {
			String[] emp = data.split(",");
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(emp[0].trim()));
			employee.setFirstName(emp[1].trim());
			employee.setLastName(emp[2].trim());
			employee.setGender(emp[3].trim());
			employee.setMobile(emp[4].trim());
			employee.setDesignation(emp[5].trim());
			employee.setManagerId(emp[6].trim());
			String[] dob = emp[7].split("-");
			employee.setDateOfBirth(LocalDate.of(Integer.parseInt(dob[0].trim()), Integer.parseInt(dob[1].trim()),
					Integer.parseInt(dob[2].trim())));
			employee.setSalary(Double.parseDouble(emp[8].trim()));
			String bonus = emp[9].trim();
			if (bonus.isBlank() || bonus.isEmpty())
				employee.setBonus(0);
			else
				employee.setBonus(Double.parseDouble(bonus));
			employee.setJoiningDate(LocalDate.now());
			int deptId = Integer.parseInt(emp[10].trim());
			if (1001 == deptId)
				employeeList1.add(employee);
			else if (2001 == deptId)
				employeeList2.add(employee);
			else if (3001 == deptId)
				employeeList3.add(employee);
			employee.setEmail(emp[11].trim());

		}

		departmentList.add(new Department(1001, "Inventory", "Ahmedabad", employeeList1));
		departmentList.add(new Department(2001, "Production", "Hyderabad", employeeList2));
		departmentList.add(new Department(3001, "Delivery", "New Delhi", employeeList3));

		for (Department department : departmentList) {
			verify(departmentDao).save(department);
			departmentService.addDepartment(department);
		}
	}

}
