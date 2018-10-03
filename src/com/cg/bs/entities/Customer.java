package com.cg.bms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer 
{
	@Id
	private String  Pancard;
	private String Customer_name, Email, Address;

	public String getCustomer_name() {
		return Customer_name;
	}

	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
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
