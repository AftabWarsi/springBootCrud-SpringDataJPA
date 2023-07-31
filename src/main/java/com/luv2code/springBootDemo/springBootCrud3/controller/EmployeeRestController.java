package com.luv2code.springBootDemo.springBootCrud3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springBootDemo.springBootCrud3.entity.Employee;
import com.luv2code.springBootDemo.springBootCrud3.exception.BusinessException;
import com.luv2code.springBootDemo.springBootCrud3.exception.ControllerException;
import com.luv2code.springBootDemo.springBootCrud3.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	private EmployeeService empService;

	@GetMapping("/employees")
	public  ResponseEntity<List<Employee>> findAll() {

		List<Employee> empList = new ArrayList<>();

		empList = empService.findAll();

		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);

	}
  // get the emeplyee on using @PathVariable
	//chnages is made
	@GetMapping("/employees/{id}")
	public  ResponseEntity<Employee> findEmpById(@PathVariable("id") int employeeId) {

		
		

		Employee emp2 = empService.findEmpById(employeeId);

		return new ResponseEntity<Employee>(emp2,HttpStatus.OK);

	}

	 // get the employees on using @RequestParam working

	@GetMapping("/empByParam")
	public ResponseEntity<Employee> findEmpByIdUsingRequestParam(@RequestParam("paramId") int paramId) {
		//System.out.println("we are in findEmpByIdUsingRequestParam");
		Employee emp2 = new Employee();

		//emp2 = empService.findEmpByIdUsingRequestParam(paramId);
		emp2 = empService.findEmpById(paramId);

		return ResponseEntity.ok(emp2);

	}
	
	
	@PostMapping("/saveEmployees")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee theEmployee) {

		//theEmployee.setId(0);
		 Employee savedEmp=empService.saveEmp(theEmployee);
		//return theEmployee;
		 return new  ResponseEntity<Employee>(savedEmp,HttpStatus.CREATED);

	}
	// save second try 
	@PostMapping("/saveSecond")
	public ResponseEntity<?> saveEmpTwo(@RequestBody Employee empTwo) {
		Employee savedEmp;
		try {
			savedEmp = empService.saveEmpTwo(empTwo);
			return new ResponseEntity<Employee>(savedEmp, HttpStatus.CREATED);
		} catch (BusinessException be) {
			System.out.println("we are in saveEmpTwo contoller "+be);
			ControllerException ce = new ControllerException(be.getErrorCode(), be.getErrorMassege());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {

			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);

		}

	

	}
	// public void deleteEmp(int id);
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<Void> deleteEmp(@PathVariable int employeeId) {

		empService.deleteEmp(employeeId);

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

	}

	@PutMapping("/update/{employeeId}")
	 public  ResponseEntity<Employee> updateEmp( @RequestBody Employee empTwo){
		 Employee savedEmp= empService.saveEmpTwo(empTwo);
		 
		return  new ResponseEntity<Employee>(savedEmp,HttpStatus.CREATED);
		
	}
}
