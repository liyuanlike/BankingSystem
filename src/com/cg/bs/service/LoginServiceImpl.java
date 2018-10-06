package com.cg.bs.service;

import java.util.Scanner;

import com.cg.bs.dao.LoginDao;
import com.cg.bs.dao.LoginDaoImpl;
import com.cg.bs.entities.UserTable;

public class LoginServiceImpl implements LoginService {

	LoginDao ldao = new LoginDaoImpl();
	Scanner sc = new Scanner(System.in);
	
	
	public boolean verifyCredentials(int username, String password) {
		return ldao.verifyCredentials(username, password);
	}
	

	@Override
	public String checklockstatus(int username, String password) {
		return ldao.checklockstatus(username, password);
	}


	@Override
	public void setpassword(int username, String new_pass) {
		ldao.setpassword(username, new_pass);
		
	}


	@Override
	public void lockAccount(int username) {
		ldao.lockAccount(username);
		
	}


	@Override
	public boolean adminLogin(int id, String password) {
		return ldao.adminLogin(id, password);
	}


	@Override
	public void updateUser(UserTable ut, int username) {
		ldao.updateUser(ut, username);
	}


	@Override
	public String checkSecretAns(int username) {
		return ldao.checkSecretAns(username);
	}
	
}
