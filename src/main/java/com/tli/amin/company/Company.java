package com.tli.amin.company;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.tli.amin.model.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="COMPANY")
public class Company extends BaseEntity{

	@NotEmpty
	@Column(name="COMPANY_NAME", nullable=false)
	private String companyName;
	
	@NotEmpty
	@Column(name="ADDR_LINE1", nullable=false)
	private String addressLine1;
	
	@NotEmpty
	@Column(name="ADDR_LINE2", nullable=false)
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

	@NotEmpty
	@Column(name="PINCODE", nullable=false)
	private String pincode;

	@Column(name = "PROFILE_DESC")
	private String profileDescription;

	/**
	 * Holds value of property date.
	 */
	@Column(name = "ESTABLISHMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date establishmentDate;

	@Column(name = "COMPANY_URL")
	private String companyWebsiteUrl;

	@NotNull
	@Column(name="YEARLY_HIRING_NO", nullable=true)
	private int yearlyHiringNo;

	@OneToOne
	@JoinColumn(name="business_stream_id")
	private BusinessStream businessStream;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "company")
	private Set<CompanyJobOffer> companyJobOffers;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "company")
	private Set<CompanyDocument> companyDocuments;

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

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public BusinessStream getBusinessStream() {
		return businessStream;
	}

	public void setBusinessStream(BusinessStream businessStream) {
		this.businessStream = businessStream;
	}

	public Date getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public String getCompanyWebsiteUrl() {
		return companyWebsiteUrl;
	}

	public void setCompanyWebsiteUrl(String companyWebsiteUrl) {
		this.companyWebsiteUrl = companyWebsiteUrl;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Set<CompanyJobOffer> getCompanyJobOffers() {
		return companyJobOffers;
	}

	public void setCompanyJobOffers(Set<CompanyJobOffer> companyJobOffers) {
		this.companyJobOffers = companyJobOffers;
	}

	public Set<CompanyDocument> getCompanyDocuments() {
		return companyDocuments;
	}

	public void setCompanyDocuments(Set<CompanyDocument> companyDocuments) {
		this.companyDocuments = companyDocuments;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Company)) return false;
		if (!super.equals(o)) return false;

		Company company = (Company) o;
		if (!getUuid().equals(company.getUuid())) return false;
		if (!getCompanyName().equals(company.getCompanyName())) return false;
		if (!getCity().equals(company.getCity())) return false;
		if (!getState().equals(company.getState())) return false;
		if (!getCountry().equals(company.getCountry())) return false;
		if (getEstablishmentDate() != null ? !getEstablishmentDate().equals(company.getEstablishmentDate()) : company.getEstablishmentDate() != null)
			return false;
		return getCompanyWebsiteUrl() != null ? getCompanyWebsiteUrl().equals(company.getCompanyWebsiteUrl()) : company.getCompanyWebsiteUrl() == null;
	}

}
