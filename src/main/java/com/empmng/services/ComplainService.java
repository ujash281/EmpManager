package com.empmng.services;


import com.empmng.entities.Complaint;
import com.empmng.payloads.ComplaintResponse;

public interface ComplainService {
	
	ComplaintResponse getAllComplaints(Integer pageNumber , Integer pageSize);
	Complaint saveComplaint(Complaint complaint , Integer empId, Integer categoryId);
	
	Complaint deleteComplaint(Integer complaintId);
}
