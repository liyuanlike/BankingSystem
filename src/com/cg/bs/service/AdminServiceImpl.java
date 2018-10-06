package com.cg.bs.service;


import java.util.List;
import java.util.Scanner;

import com.cg.bs.dao.AdminDao;
import com.cg.bs.dao.AdminDaoImpl;
import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.Transactions;
import com.cg.bs.entities.UserTable;


public class AdminServiceImpl implements AdminService {

	static Scanner sc = new Scanner(System.in);
	AdminDao adao = new AdminDaoImpl();
	
	

	@Override
	public boolean chechUser(int userId) {
		return adao.chechUser(userId);
	}


	@Override
	public List<Transactions> getPeriodicalTransaction(String startDate,
			String endDate) {
		
		return adao.getPeriodicalTransaction(startDate, endDate);
	}


	@Override
	public void addCustomer(Customer cust) {
		adao.addCustomer(cust);
		
	}


	@Override
	public void addUser(UserTable ut) {
		adao.addUser(ut);
		
	}


	@Override
	public void addAccount(AccountMaster am) {
		adao.addAccount(am);
		
	}

	
	
	
}
