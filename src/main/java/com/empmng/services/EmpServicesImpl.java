package com.empmng.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.empmng.config.AppConstants;
import com.empmng.entities.Employee;
import com.empmng.entities.Role;
import com.empmng.exception.ResourseNotFoundException;
import com.empmng.repo.EmpRepo;
import com.empmng.repo.RoleRepo;

@Service
public class EmpServicesImpl implements EmpServices {
	
	@Autowired
	private EmpRepo empRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private PasswordEncoder passwwordEncoder;
	

	@Override
	public Employee saveEmployee(Employee employee) {
		
		//created seperate API to store the photo so saving default here
		employee.setPhoto("default.png");
		
		Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		employee.getRoles().add(role);
		
		employee.setPassword(passwwordEncoder.encode(employee.getPassword()));
		return empRepo.save(employee);
		
	}


	@Override
	public Employee getEmployee(Integer empId) {
		Employee emp = this.empRepo.findById(empId).orElseThrow(
				()-> new ResourseNotFoundException("Emp", "Emp id", empId));
		return emp;
	}


	@Override
	public Employee updateEmp(Employee employee, Integer empId) {
		
		Employee emp = this.empRepo.findById(empId).orElseThrow(
				()-> new ResourseNotFoundException("Emp", "Emp id", empId));
		
		emp.setName(employee.getName());
		emp.setMobile(employee.getMobile());
		//emp.setPhoto(employee.getPhoto());
		emp.setPassword(passwwordEncoder.encode(employee.getPassword()));
		Employee updatedPost = this.empRepo.save(emp);
		
		return updatedPost;
	}

}
