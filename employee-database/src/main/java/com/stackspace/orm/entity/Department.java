package com.stackspace.orm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2908845241191642969L;
	private int id;
	private String name;
	private String location;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	@JoinColumn(name = "department")
	private List<Employee> employees;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int id, String name, String location, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
