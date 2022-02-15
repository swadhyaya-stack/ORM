package com.stackspace.orm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stackspace.orm.entity.Department;
import com.stackspace.orm.util.HibernateUtil;

public class DepartmentDaoImpl implements DepartmentDao<Department, Serializable> {

	@Override
	public void save(Department department) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(department);
			transaction.commit();
		}
	}

	@Override
	public void update(Department department) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(department);
			transaction.commit();
		}
	}

	@Override
	public Department findById(int departmentId) {
		Department department = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			department = session.load(Department.class, departmentId);
			transaction.commit();
		}
		return department;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		List<Department> departmentList = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			departmentList = session.createQuery("from Department").list();
			transaction.commit();
		}
		return departmentList;
	}

	@Override
	public void delete(Department department) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			session.delete(transaction);
			transaction.commit();
		}
	}
}
