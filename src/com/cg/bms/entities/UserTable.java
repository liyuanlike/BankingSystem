package com.cg.bms.entities;

public class UserTable 
{
	
	private int user_ID;
	private String login_Password, secret_Question, transaction_Password, lock_Status, pancard;
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	public String getLogin_Password() {
		return login_Password;
	}
	public void setLogin_Password(String login_Password) {
		this.login_Password = login_Password;
	}
	public String getSecret_Question() {
		return secret_Question;
	}
	public void setSecret_Question(String secret_Question) {
		this.secret_Question = secret_Question;
	}
	public String getTransaction_Password() {
		return transaction_Password;
	}
	public void setTransaction_Password(String transaction_Password) {
		this.transaction_Password = transaction_Password;
	}
	public String getLock_Status() {
		return lock_Status;
	}
	public void setLock_Status(String lock_Status) {
		this.lock_Status = lock_Status;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	

}
