package com.cg.bms.entities;

public class PayeeTable {

	private int Account_Id, Payee_Account_Id;
	private String Nick_name;
	
	
	public PayeeTable() {
		super();
	}
	
	
	public PayeeTable(int account_Id, int payee_Account_Id, String nick_name) {
		super();
		Account_Id = account_Id;
		Payee_Account_Id = payee_Account_Id;
		Nick_name = nick_name;
	}
	
	
	@Override
	public String toString() {
		return "PayeeTable [Account_Id=" + Account_Id + ", Payee_Account_Id="
				+ Payee_Account_Id + ", Nick_name=" + Nick_name + "]";
	}
	
	
	public int getAccount_Id() {
		return Account_Id;
	}
	public void setAccount_Id(int account_Id) {
		Account_Id = account_Id;
	}
	
	
	public int getPayee_Account_Id() {
		return Payee_Account_Id;
	}
	public void setPayee_Account_Id(int payee_Account_Id) {
		Payee_Account_Id = payee_Account_Id;
	}
	
	
	public String getNick_name() {
		return Nick_name;
	}
	public void setNick_name(String nick_name) {
		Nick_name = nick_name;
	}
	
	
}
