package com.empmng.payloads;

import java.util.List;

import com.empmng.entities.Complaint;

public class ComplaintResponse {
	
	private List<Complaint> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean islastPage;
	public List<Complaint> getContent() {
		return content;
	}
	public void setContent(List<Complaint> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isIslastPage() {
		return islastPage;
	}
	public void setIslastPage(boolean islastPage) {
		this.islastPage = islastPage;
	}
	public ComplaintResponse(List<Complaint> content, int pageNumber, int pageSize, long totalElements, int totalPages,
			boolean islastPage) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.islastPage = islastPage;
	}
	public ComplaintResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PostResponse [content=" + content + ", pageNumber=" + pageNumber + ", pageSize=" + pageSize
				+ ", totalElements=" + totalElements + ", totalPages=" + totalPages + ", islastPage=" + islastPage
				+ "]";
	}
	
	
}
