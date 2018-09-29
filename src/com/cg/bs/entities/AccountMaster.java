package com.cg.bs.entities;


public class AccountMaster {
	
	private int Account_ID, Account_Balance;
	private String Account_Type;
	
	
	public int getAccount_ID() {
		return Account_ID;
	}
	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
	}
	
	
	public int getAccount_Balance() {
		return Account_Balance;
	}
	public void setAccount_Balance(int account_Balance) {
		Account_Balance = account_Balance;
	}
	
	
	public String getAccount_Type() {
		return Account_Type;
	}
	public void setAccount_Type(String account_Type) {
		Account_Type = account_Type;
	}
	
	
	@Override
	public String toString() {
		return "AccountMaster [Account_ID=" + Account_ID + ", Account_Balance="
				+ Account_Balance + ", Account_Type=" + Account_Type + "]";
	}
	
	
	public AccountMaster(int account_ID, int account_Balance,
			String account_Type) {
		super();
		Account_ID = account_ID;
		Account_Balance = account_Balance;
		Account_Type = account_Type;
	}
	
	
	public AccountMaster() {
		super();
	}
	
	
	

}
