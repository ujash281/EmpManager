package com.empmng.services;

import java.util.List;

import com.empmng.entities.Complaint;

public interface ComplainService {
	
	List<Complaint> getAllComplaints();
	Complaint saveComplaint(Complaint complaint);
}
