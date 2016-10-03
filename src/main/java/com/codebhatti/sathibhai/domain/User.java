package com.codebhatti.sathibhai.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "users")
@NamedQueries({
	@NamedQuery(name=User.FINDALL, query="Select u from User u")
})
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 982569218749893173L;
	private static final String DOMAIN_PREFIX = "com.codebhatti.sathibhai.domain.User";
	public static final String FINDALL = DOMAIN_PREFIX + "FINDALL";
	
	public User(String emailAddress, String firstName, String lastName){
		this.emailAddress=emailAddress;
		this.firstName=firstName;
		this.lastName=lastName;
		//this.addresses=addresses;
		
	}

	@Id
	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "country_of_origin")
	private String countryOfOrigin;
	@Column(name = "dob")
	private String dateOfBirth;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "ssn")
	private String socialSecurityNo;

	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Address> addresses=new HashSet<>();

	private String password;
	private String secretAnswer1;
	private String secretAnswer2;
	private String secretAnswer3;
	private String securityCode;
	private boolean isActive;

	public User() {
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSocialSecurityNo() {
		return socialSecurityNo;
	}

	public void setSocialSecurityNo(String socialSecurityNo) {
		this.socialSecurityNo = socialSecurityNo;
	}

	public void addAddress(Address address) {
		if(address==null)
			throw new IllegalArgumentException("Address is NULL");
		this.addresses.add(address);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecretAnswer1() {
		return secretAnswer1;
	}

	public void setSecretAnswer1(String secretAnswer1) {
		this.secretAnswer1 = secretAnswer1;
	}

	public String getSecretAnswer2() {
		return secretAnswer2;
	}

	public void setSecretAnswer2(String secretAnswer2) {
		this.secretAnswer2 = secretAnswer2;
	}

	public String getSecretAnswer3() {
		return secretAnswer3;
	}

	public void setSecretAnswer3(String secretAnswer3) {
		this.secretAnswer3 = secretAnswer3;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
