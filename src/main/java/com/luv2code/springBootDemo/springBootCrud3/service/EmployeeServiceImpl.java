package com.luv2code.springBootDemo.springBootCrud3.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springBootDemo.springBootCrud3.entity.Employee;
import com.luv2code.springBootDemo.springBootCrud3.exception.BusinessException;
import com.luv2code.springBootDemo.springBootCrud3.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	 private EmployeeRepository employeeRepository;

	@Override

	public List<Employee> findAll() {
		// this is only for checking git demo 
		// this is only for checout test
		// this comment to show diff command
		return employeeRepository.findAll();
	}

	@Override
	public  Employee saveEmp(Employee empPara) {
		 Employee employee;
		return employee = employeeRepository.save(empPara);
		
	}

	@Override
	public void deleteEmp(int id) {
		employeeRepository.deleteById(id);
	
	
		
	}

	@Override
	public Employee findEmpById(int id) {
		Employee theEmp=null;
		
		Optional<Employee> result= employeeRepository.findById(id);
		if (result.isPresent()) {
			
			theEmp=result.get();
		}
		
		else {
			
			throw new RuntimeException("Did not find the id :"+id);
		}
		return theEmp;
		
		
	}

	@Override
	public Employee findEmpByIdUsingRequestParam(int paramId) {
	Employee theEmp=null;
		
		Optional<Employee> result= employeeRepository.findById(paramId);
		if (result.isPresent()) {
			
			theEmp=result.get();
		}
		
		else {
			
			throw new RuntimeException("Did not find the id"+paramId);
		}
		return theEmp;
		
		
	}

	@Override
	public Employee saveEmpTwo(Employee employeeTwo) {
		Employee employeeSaved = null;
		if (employeeTwo.getFirstName().isEmpty() || employeeTwo.getFirstName().length() == 0) {
			  throw new BusinessException("601", "please fill the fisrt Name , it is Blank");
		}
		try {
			employeeSaved = employeeRepository.save(employeeTwo);
			return employeeSaved;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602",
					"please fill the form and then submit , all field is Blank" + e.getMessage());

		} catch (Exception e) {
			throw new BusinessException("603",
					"please fill the for emplyee details is null" + e.getMessage());

		}
		
	}

}
