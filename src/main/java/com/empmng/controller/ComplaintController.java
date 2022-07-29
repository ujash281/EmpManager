package com.empmng.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.empmng.config.AppConstants;
import com.empmng.entities.Complaint;
import com.empmng.payloads.ComplaintResponse;
import com.empmng.services.ComplainService;

@RestController
public class ComplaintController {

	@Autowired
	private ComplainService complainService;

	@GetMapping("/getAllComplaints")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<ComplaintResponse> getAllComplaints(
			@RequestParam(defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize) {
		ComplaintResponse complaintResponse = this.complainService.getAllComplaints(pageNumber, pageSize);
		return new ResponseEntity<ComplaintResponse>(complaintResponse, HttpStatus.OK);
	}

	@PostMapping("/saveComplaint/emp/{empId}/cat/{categoryId}")
	public ResponseEntity<Complaint> saveComplaint(@RequestBody Complaint complaint, @PathVariable Integer empId,
			@PathVariable Integer categoryId) {

		Complaint savedComplaint = this.complainService.saveComplaint(complaint, empId, categoryId);
		return new ResponseEntity<Complaint>(savedComplaint, HttpStatus.CREATED);

	}
	@DeleteMapping("/withdrawComplaint/{complaintId}")
	public ResponseEntity<Complaint> deleteComplaint(@PathVariable Integer complaintId) {
		
		Complaint withdrawedComplaint = this.complainService.deleteComplaint(complaintId);
		return new ResponseEntity<Complaint>(withdrawedComplaint,HttpStatus.OK);
	}

}
