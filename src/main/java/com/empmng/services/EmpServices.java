package com.empmng.services;



import com.empmng.entities.Employee;



public interface EmpServices {

	Employee saveEmployee(Employee employee);
	
	Employee getEmployee(Integer empId);

	Employee updateEmp(Employee employee, Integer empId);
	
}
