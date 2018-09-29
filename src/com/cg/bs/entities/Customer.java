package com.cg.bs.entities;

public class Customer {

	private int Account_ID;
	private String customer_name, Email, Address, Pancard;
	
	
	public Customer() {
		super();
	}
	
	
	public Customer(int account_ID, String customer_name, String email,
			String address, String pancard) {
		super();
		Account_ID = account_ID;
		this.customer_name = customer_name;
		Email = email;
		Address = address;
		Pancard = pancard;
	}
	
	
	@Override
	public String toString() {
		return "Customer [Account_ID=" + Account_ID + ", customer_name="
				+ customer_name + ", Email=" + Email + ", Address=" + Address
				+ ", Pancard=" + Pancard + "]";
	}
	
	
	public int getAccount_ID() {
		return Account_ID;
	}
	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
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
