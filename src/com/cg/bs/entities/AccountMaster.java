package com.cg.bms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Table;
=======
import javax.persistence.SequenceGenerator;
>>>>>>> 7ed87ac071f5812467946433cfd1b6a8d1e6c1a8

@Entity
@Table(name="ACCOUNTMASTER")
public class AccountMaster 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", sequenceName="seq_account_id", allocationSize=1)
	private int Account_ID;
	private int User_ID, Account_Balance;
	private String Account_Type;
<<<<<<< HEAD
	
=======
	private double Account_Balance;
	Date open_date;
	public AccountMaster() {
		super();
	}
	
	public AccountMaster(int account_ID, int user_id, String account_Type,
			double account_Balance, Date open_date) {
		super();
		Account_ID = account_ID;
		this.user_id = user_id;
		Account_Type = account_Type;
		Account_Balance = account_Balance;
		this.open_date = open_date;
	}

>>>>>>> 7ed87ac071f5812467946433cfd1b6a8d1e6c1a8
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
<<<<<<< HEAD
	public int getAccount_Balance() {
		return Account_Balance;
	}
	public void setAccount_Balance(int account_Balance) {
		Account_Balance = account_Balance;
	}
	public String getAccount_Type() {
		return Account_Type;
=======
	
	public double getAccount_Balance() {
		return Account_Balance;
	}

	public void setAccount_Balance(double account_Balance) {
		Account_Balance = account_Balance;
	}

	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
>>>>>>> 7ed87ac071f5812467946433cfd1b6a8d1e6c1a8
	}
	public void setAccount_Type(String account_Type) {
		Account_Type = account_Type;
	}

}
