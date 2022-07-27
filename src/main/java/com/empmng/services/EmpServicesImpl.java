package com.empmng.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.empmng.entities.Employee;
import com.empmng.repo.EmpRepo;

@Service
public class EmpServicesImpl implements EmpServices {
	
	@Autowired
	private EmpRepo empRepo;
	
	@Autowired
	private PasswordEncoder passwwordEncoder;
	

	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setPassword(passwwordEncoder.encode(employee.getPassword()));
		return empRepo.save(employee);
		
	}

}
