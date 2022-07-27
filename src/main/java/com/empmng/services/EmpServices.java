package com.empmng.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.empmng.entities.Employee;



public interface EmpServices {

	Employee saveEmployee(Employee employee);
	
}
