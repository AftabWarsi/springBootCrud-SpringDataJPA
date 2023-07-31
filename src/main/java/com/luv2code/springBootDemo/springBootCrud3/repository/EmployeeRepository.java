package com.luv2code.springBootDemo.springBootCrud3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springBootDemo.springBootCrud3.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



}
