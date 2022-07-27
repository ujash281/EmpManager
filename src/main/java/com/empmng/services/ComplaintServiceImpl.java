package com.empmng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmng.entities.Complaint;
import com.empmng.repo.ComplaintRepo;

@Service
public class ComplaintServiceImpl implements ComplainService {
	@Autowired
	private ComplaintRepo complaintRepo;

	@Override
	public List<Complaint> getAllComplaints() {
		
		return complaintRepo.findAll();
	}

	@Override
	public Complaint saveComplaint(Complaint complaint) {
		
		return complaintRepo.save(complaint);
	}

}
