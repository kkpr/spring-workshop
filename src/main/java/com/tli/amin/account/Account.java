package com.tli.amin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String firstname;

	private String lastname;

	private String companyname;

	private String designation;

	private String phonenumber;

	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	private Instant created;

    protected Account() {

	}
	
	public Account(String firstname,String lastname,String companyname,String designation,String phonenumber,
				   String email, String password, String role) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.companyname = companyname;
		this.designation = designation;
		this.phonenumber = phonenumber;
    	this.email = email;
		this.password = password;
		this.role = role;
		this.created = Instant.now();
	}

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Instant getCreated() {
		return created;
	}
}
