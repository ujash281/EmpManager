package com.empmng.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.empmng.entities.Employee;
import com.empmng.exception.ApiException;
import com.empmng.payloads.JwtAuthRequest;
import com.empmng.payloads.JwtAuthResponse;
import com.empmng.repo.EmpRepo;
import com.empmng.security.JwtTokenHelper;
import com.empmng.services.EmpServices;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private EmpServices empServices;
	
	@Autowired
	private EmpRepo empRepo;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(
		@RequestBody JwtAuthRequest request	) throws Exception {
		System.out.println("++0"+request.getUsername());
		this.authenticate(request.getUsername() , request.getPassword());
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		System.out.println("dddd"+userDetails);
		String token = this.jwtTokenHelper.generateToken(userDetails);
		
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(response , HttpStatus.OK); 
	}

	private void authenticate(String username, String password) throws Exception {
		
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(username, password);
	
			try {
				this.authenticationManager.authenticate(authenticationToken);
			} catch (BadCredentialsException e) {
				
				System.out.println("Invalid Username or password");
				throw new ApiException("Invalid Username or password");
			}
			
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody Employee employee){
		 Employee email = this.empRepo.findByEmail(employee.getEmail());
		   if(email!=null) {
			   return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body("{\"error\":\"User already exitst\"}");
			
		   }else {
			
			   Employee registeredUser = this.empServices.saveEmployee(employee);
				return new ResponseEntity<Employee>(registeredUser , HttpStatus.CREATED);
		}
		    
		
	}
 	
}
