package com.cg.bs.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class AccountMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", sequenceName="seq_account_id", allocationSize=1)
	private int Account_ID;
	private int user_id;
	private String Account_Type;
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

	public int getAccount_ID() {
		return Account_ID;
	}
	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAccount_Type() {
		return Account_Type;
	}
	public void setAccount_Type(String account_Type) {
		Account_Type = account_Type;
	}
	
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
	}
	@Override
	public String toString() {
		return "AccountMaster [Account_ID=" + Account_ID + ", user_id="
				+ user_id + ", Account_Type=" + Account_Type
				+ ", Account_Balance=" + Account_Balance + ", open_date="
				+ open_date + "]";
	}
	
	
}
