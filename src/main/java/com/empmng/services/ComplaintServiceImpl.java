package com.empmng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empmng.entities.Category;
import com.empmng.entities.Complaint;
import com.empmng.entities.Employee;
import com.empmng.exception.ResourseNotFoundException;
import com.empmng.payloads.ComplaintResponse;
import com.empmng.repo.CategoryRepo;
import com.empmng.repo.ComplaintRepo;
import com.empmng.repo.EmpRepo;

@Service
public class ComplaintServiceImpl implements ComplainService {
	@Autowired
	private ComplaintRepo complaintRepo;

	@Autowired
	private EmpRepo empRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Complaint saveComplaint(Complaint complaint, Integer empId, Integer categoryId) {

		Employee emp = this.empRepo.findById(empId)
				.orElseThrow(() -> new ResourseNotFoundException("Emp", "Emp Id", empId));

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourseNotFoundException("Category", "Category Id", categoryId));

		complaint.setCategory(category);
		complaint.setEmployee(emp);
		complaint.setStatus("pending");
		complaint.setReplieDate(null);
		complaint.setReply(null);
		Complaint savedComplaint = this.complaintRepo.save(complaint);
		return savedComplaint;
	}

	@Override
	public ComplaintResponse getAllComplaints(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber, pageSize);

		Page<Complaint> pageComplaint = this.complaintRepo.findAll(p);
		List<Complaint> complaints = pageComplaint.getContent();
		ComplaintResponse complaintResponse = new ComplaintResponse();

		complaintResponse.setContent(complaints);
		complaintResponse.setPageNumber(pageComplaint.getNumber());
		complaintResponse.setPageSize(pageComplaint.getSize());
		complaintResponse.setTotalElements(pageComplaint.getTotalElements());
		complaintResponse.setTotalPages(pageComplaint.getTotalPages());
		complaintResponse.setIslastPage(pageComplaint.isLast());

		return complaintResponse;
	}

	@Override
	public Complaint deleteComplaint(Integer complaintId) {
		Complaint complaint = this.complaintRepo.findById(complaintId)
				.orElseThrow(() -> new ResourseNotFoundException("Complaint", "Complaint Id", complaintId));
		complaint.setStatus("withdrawal");
		return this.complaintRepo.save(complaint);
	}

}
