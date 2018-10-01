package com.cg.bs.dao;

public interface LoginDao {

	public boolean verifyCredentials(int username, String password, String role);

	public String checklockstatus(int username, String password);

	public void lockAccount(int username);

	public String checkSecretAns(int username);

	public void setpassword(int username, String string);
}
