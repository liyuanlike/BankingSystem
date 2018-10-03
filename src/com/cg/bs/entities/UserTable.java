package com.cg.bms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UserTable 
{
	@Id
<<<<<<< HEAD
	private int user_ID;
	private String login_Password, secret_Question, transaction_Password, lock_Status, pancard;
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
=======
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", sequenceName="seq_user_id", allocationSize=1)
	private int user_id;
	private String login_password, secret_question, Transaction_password, lock_status, Pancard;
	
	
	public UserTable() {
		super();
	}

	public UserTable(int user_id, String login_password,
			String secret_question, String transaction_password,
			String lock_status, String pancard, String role) {
		super();
		this.user_id = user_id;
		this.login_password = login_password;
		this.secret_question = secret_question;
		Transaction_password = transaction_password;
		this.lock_status = lock_status;
		Pancard = pancard;
		
	}





	@Override
	public String toString() {
		return "UserTable [user_id=" + user_id + ", login_password="
				+ login_password + ", secret_question=" + secret_question
				+ ", Transaction_password=" + Transaction_password
				+ ", lock_status=" + lock_status + ", Pancard=" + Pancard
				+ "]";
	}





	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
>>>>>>> 7ed87ac071f5812467946433cfd1b6a8d1e6c1a8
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
