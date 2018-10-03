package com.cg.bms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNTMASTER")
public class AccountMaster 
{
	@Id
	private int Account_ID;
	private int User_ID, Account_Balance;
	private String Account_Type;
	
	public int getAccount_ID() {
		return Account_ID;
	}
	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
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

}
