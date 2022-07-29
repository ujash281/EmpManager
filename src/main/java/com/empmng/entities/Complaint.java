package com.empmng.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaintId;
	
	private String decription;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
	private String reply;
	private String status;
	private Date replieDate;
	
	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getReplieDate() {
		return replieDate;
	}

	public void setReplieDate(Date replieDate) {
		this.replieDate = replieDate;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public Complaint(int complaintId, String decription, Category category, Employee employee, String reply,
			String status, Date replieDate) {
		super();
		this.complaintId = complaintId;
		this.decription = decription;
		this.category = category;
		this.employee = employee;
		this.reply = reply;
		this.status = status;
		this.replieDate = replieDate;
	}

	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
