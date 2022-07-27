package com.empmng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empmng.entities.Complaint;
import com.empmng.services.ComplainService;

@RestController
public class ComplaintController {
	
	@Autowired
	
	private ComplainService complainService;
	@GetMapping("/getAllComplaints")
	List<Complaint> getAllComplaints() {
		
		return complainService.getAllComplaints();
	}
	
	@PostMapping("/saveComplaint")
	Complaint saveComplaint(@RequestBody Complaint complaint) {
		System.out.println("jjjjjjjjjj"+complaint.getCategory());
		return complainService.saveComplaint(complaint);
	}

}
