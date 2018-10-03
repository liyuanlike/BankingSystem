package com.cg.bms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
<<<<<<< HEAD
=======
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	private String Pancard;
	private String customer_name, Email, Address;
	
	
	
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
>>>>>>> 7ed87ac071f5812467946433cfd1b6a8d1e6c1a8

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
