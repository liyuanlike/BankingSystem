package com.cg.bs.entities;

public class Customer {

	
	private String customer_name, Email, Address, Pancard;
	
	
	public Customer() {
		super();
	}


	public Customer(String customer_name, String email, String address,
			String pancard) {
		super();
		this.customer_name = customer_name;
		Email = email;
		Address = address;
		Pancard = pancard;
	}


	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPancard() {
		return Pancard;
	}


	public void setPancard(String pancard) {
		Pancard = pancard;
	}
	
	
}
