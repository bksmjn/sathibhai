package com.codebhatti.sathibhai.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum AddressType {
		PERMANENT, TEMPORARY
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long addressCode;
	private String street;
	private String city;
	private String zipCode;
	private String state;
	private AddressType addressType;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Address() {

	}

	public Long getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(Long addressCode) {
		this.addressCode = addressCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
