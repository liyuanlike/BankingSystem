package com.cg.bs.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import com.cg.bs.dao.AdminDao;
import com.cg.bs.dao.AdminDaoImpl;
import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.UserTable;

public class AdminServiceImpl implements AdminService {

	static Scanner sc = new Scanner(System.in);
	AdminDao adao = new AdminDaoImpl();
	
	@Override
	public void adminHome() {
		
		int operation;
		System.out.println("Enter your choice: "+"\n1)Create new account"+"\n2)View Transactions");
		operation=sc.nextInt();
		switch(operation)
		{
			case 1: addAccount();
					break;
		}
	}

	private void addAccount() {
		String customer_name, Email, Address, Pancard;
		String Account_Type;
		double Account_Balance;
		String login_password;
		System.out.println("Enter Customer Name: ");
		customer_name = sc.next();
		System.out.println("Enter Email id: ");
		Email = sc.next();
		System.out.println("Enter Address: ");
		Address = sc.next();
		System.out.println("Enter Pan Card Number: ");
		Pancard = sc.next();
		System.out.println("Enter the Account Type: ");
		Account_Type=sc.next();
		System.out.println("Enter the Account Balance: ");
		Account_Balance=sc.nextDouble();
		login_password="1asd40#";
		String lock_status = "o";
		Calendar currenttime = Calendar.getInstance();
	    Date sqldate = new Date((currenttime.getTime()).getTime());
	    
		Customer cust = new Customer(customer_name, Email, Address, Pancard);
		adao.addCustomer(cust);
		
		UserTable ut = new UserTable();
		ut.setLogin_password(login_password);
		ut.setPancard(Pancard);
		ut.setLock_status(lock_status);
		adao.addUser(ut);
		
		AccountMaster am = new AccountMaster();
		am.setAccount_Type(Account_Type);
		am.setAccount_Balance(Account_Balance);
		am.setOpen_date(sqldate);
		am.setUser_id(ut.getUser_id());
		adao.addAccount(am);
	}

}
