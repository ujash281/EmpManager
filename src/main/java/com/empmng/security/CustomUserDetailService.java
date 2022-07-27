package com.empmng.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.empmng.entities.Employee;
import com.empmng.repo.EmpRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private EmpRepo empRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//loading user from db by user name
		System.out.println("0000000"+ username);
		Employee employee = this.empRepo.findByEmail(username);
		
		return employee;
	}

}
