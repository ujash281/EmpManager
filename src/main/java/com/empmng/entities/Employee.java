package com.empmng.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "employees")
public class Employee implements UserDetails {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	@NotEmpty
	@Size(min = 3 , max = 10 , message = "Name should be bewteen 3 to 10 characters!!")
	private String name;
	

	@Column(name = "email")
	@NotEmpty
	@Email
	private String email;
	
	
	private String photo;

	@NotEmpty
	private String mobile;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String status;
	
	@NotEmpty
	private String workingType;
	

	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Complaint> complaints = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet<>();


	public String getWorkingType() {
		return workingType;
	}

	public void setWorkingType(String workingType) {
		this.workingType = workingType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	

	public Employee(Integer id,
			@NotEmpty @Size(min = 3, max = 10, message = "Name should be bewteen 3 to 10 characters!!") String name,
			@NotEmpty @Email String email, String photo, @NotEmpty String mobile, @NotEmpty String password,
			@NotEmpty String status, @NotEmpty String workingType, List<Complaint> complaints, Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.mobile = mobile;
		this.password = password;
		this.status = status;
		this.workingType = workingType;
		this.complaints = complaints;
		this.roles = roles;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", photo=" + photo + ", mobile=" + mobile
				+ ", password=" + password + ", status=" + status + ", workingType=" + workingType + ", complaints="
				+ complaints + ", roles=" + roles + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = this.roles.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
