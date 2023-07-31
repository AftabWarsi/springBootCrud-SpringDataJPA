package com.luv2code.springBootDemo.springBootCrud3.service;

import java.util.List;

import com.luv2code.springBootDemo.springBootCrud3.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findEmpById(int id);

	public Employee saveEmp(Employee saveEmp);
	
	public void deleteEmp(int id);

	public Employee findEmpByIdUsingRequestParam(int paramId);

	public Employee saveEmpTwo(Employee empTwo);

	//Employee findEmpById(int id);

	//Employee findEmpById(int id);
	
}
