package com.empmng.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.empmng.entities.Employee;
import com.empmng.services.EmpServices;
import com.empmng.services.FileService;

@RestController
public class EmpController {

	@Autowired
	private EmpServices empServices;

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

//	@PostMapping("/saveEmp")
//	public Employee saveEmp(@RequestBody Employee employee) {
//
//		System.out.println(employee);
//
//		empServices.saveEmployee(employee);
//		return employee;
//
//	}
	
	
	@PutMapping("/updateEmp/{empId}")
	public ResponseEntity<Employee> updateEmp(
		 @RequestBody Employee employee , @PathVariable Integer empId) {
		
		Employee updatedPost = this.empServices.updateEmp(employee, empId);
		return new ResponseEntity<Employee>(updatedPost,HttpStatus.OK);
	}
	

	// Emp image upload
	@PostMapping("/imageUpload/{empId}")
	public ResponseEntity<Employee> uploadImage(@RequestParam("image") MultipartFile imageFile,
			@PathVariable Integer empId) throws IOException {
		Employee employee = this.empServices.getEmployee(empId);
		String imageName = this.fileService.uploadImage(path, imageFile);
		employee.setPhoto(imageName);
		Employee updatedEmp = this.empServices.updateEmp(employee, empId);
		return new ResponseEntity<Employee>(updatedEmp, HttpStatus.OK);
	}

}
