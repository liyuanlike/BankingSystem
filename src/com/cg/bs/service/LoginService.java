package com.cg.bs.service;

public interface LoginService {
	
	public boolean verifyCredentials(int username, String password, String role);

	public void login();
	public void forgotPassword(int username);

}
