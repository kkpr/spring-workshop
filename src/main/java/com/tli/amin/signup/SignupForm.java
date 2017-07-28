package com.tli.amin.signup;

import com.tli.amin.account.Account;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SignupForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";

	@NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String firstname;
	@NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String lastname;
	@NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String companyname;
	@NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String designation;
	@NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String phonenumber;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	@Email(message = SignupForm.EMAIL_MESSAGE)
	private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String password;

	@NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String confirmPassword;

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Account createAccount() {

        return new Account(getFirstname(),getLastname(),getCompanyname(),getDesignation(),getPhonenumber(),getEmail(), getPassword(), "ROLE_USER");
	}
}
