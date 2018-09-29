package com.cg.bs.entities;

public class UserTable {
	
	private int Account_ID, user_id;
	private String login_password, secret_question, Transaction_password, lock_status;
	
	
	public UserTable() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserTable(int account_ID, int user_id, String login_password,
			String secret_question, String transaction_password,
			String lock_status) {
		super();
		Account_ID = account_ID;
		this.user_id = user_id;
		this.login_password = login_password;
		this.secret_question = secret_question;
		Transaction_password = transaction_password;
		this.lock_status = lock_status;
	}


	@Override
	public String toString() {
		return "UserTable [Account_ID=" + Account_ID + ", user_id=" + user_id
				+ ", login_password=" + login_password + ", secret_question="
				+ secret_question + ", Transaction_password="
				+ Transaction_password + ", lock_status=" + lock_status + "]";
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


	public String getLogin_password() {
		return login_password;
	}


	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}


	public String getSecret_question() {
		return secret_question;
	}


	public void setSecret_question(String secret_question) {
		this.secret_question = secret_question;
	}


	public String getTransaction_password() {
		return Transaction_password;
	}


	public void setTransaction_password(String transaction_password) {
		Transaction_password = transaction_password;
	}


	public String getLock_status() {
		return lock_status;
	}


	public void setLock_status(String lock_status) {
		this.lock_status = lock_status;
	}
	
	

}
