package com.empmng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empmng.entities.Employee;
import com.empmng.services.EmpServices;

@RestController
public class EmpController {
	
	@Autowired
	private EmpServices empServices;
	
	@PostMapping("/saveEmp")
	public Employee saveEmp(@RequestBody Employee employee) {
		
		System.out.println(employee);
		
		empServices.saveEmployee(employee);
		return employee;
		
	}

}
