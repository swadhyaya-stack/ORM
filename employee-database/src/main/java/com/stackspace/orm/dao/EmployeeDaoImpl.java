package com.stackspace.orm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stackspace.orm.entity.Employee;
import com.stackspace.orm.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao<Employee, Serializable> {

	@Override
	public void save(Employee employee) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		}
	}

	@Override
	public void update(Employee employee) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
		}
	}

	@Override
	public Employee findById(int employeeId) {
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			employee = session.load(Employee.class, employeeId);
			transaction.commit();
		}
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		List<Employee> employeeList = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			employeeList = session.createQuery("from Employee").list();
			transaction.commit();
		}
		return employeeList;
	}

	@Override
	public void delete(Employee employee) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			session.delete(employee);
			transaction.commit();
		}
	}

}
