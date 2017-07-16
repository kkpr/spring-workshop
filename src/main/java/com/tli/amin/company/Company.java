package com.tli.amin.company;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.tli.amin.model.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="COMPANY")
public class Company extends BaseEntity{

	@NotEmpty
	@Column(name="COMPANY_NAME", nullable=false)
	private String companyName;
	
	@NotEmpty
	@Column(name="addr_line1", nullable=false)	
	private String addressLine1;
	
	@NotEmpty
	@Column(name="addr_line2", nullable=false)	
	private String addressLine2;
	
	@NotEmpty
	@Column(name="CITY", nullable=false)	
	private String city;
	
	@NotEmpty
	@Column(name="STATE", nullable=false)
	private String state;
	
	@NotEmpty
	@Column(name="COUNTRY", nullable=false)
	private String country;
	
	@NotNull
	@Column(name="YEARLY_HIRING_NO", nullable=false)
	private int yearlyHiringNo;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getYearlyHiringNo() {
		return yearlyHiringNo;
	}

	public void setYearlyHiringNo(int yearlyHiringNo) {
		this.yearlyHiringNo = yearlyHiringNo;
	}
	
	
}
