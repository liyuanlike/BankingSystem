package com.cg.bs.service;

import com.cg.bs.entities.UserTable;

public interface LoginService {
	
	public boolean verifyCredentials(int username, String password);

	public String checklockstatus(int username, String password);

	public void setpassword(int username, String new_pass);

	public void lockAccount(int username);

	public boolean adminLogin(int id, String password);

	public void updateUser(UserTable ut, int username);

	public String checkSecretAns(int username);

}
