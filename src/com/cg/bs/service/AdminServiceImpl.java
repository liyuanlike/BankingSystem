package com.cg.bs.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

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
	public void adminHome() {
		
		int operation;
		System.out.println("Enter your choice: "+"\n1)Create new customer"+"\n2)Create account for existing user"+"\n3)View Transactions");
		operation=sc.nextInt();
		switch(operation)
		{
			case 1: addNewCustomer();
					break;
			case 2: addAccount();
					break;
			case 3:  getPeriodicalTransaction();
					break;
			default: System.out.println("Invalid Input");
					 break;
		}
	}

	
	public void getPeriodicalTransaction() 
	{
		System.out.println("Enter Start Date in DD-Mon-YY format:");
		String startDate=sc.next();
		System.out.println("Enter End Date in DD-Mon-YY format:");
		String endDate=sc.next();
		List<Transactions> tnx = adao.getPeriodicalTransaction(startDate, endDate);
		if(!tnx.isEmpty())
		{
			System.out.println("Tnx ID\tTnx Date\tType\tAmount\tDescription");
			for(Transactions t:tnx)
				System.out.println(t.getTransaction_ID()+"\t"+t.getDateOfTransaction()
									+"\t"+t.getTransactionType()+"\t"+t.getTranAmount()+"\t"+t.getTran_description());
		}
		else
			System.out.println("No Transaction made by you till now.");
	}

	private void addAccount() {
		System.out.println("Enter User_Id of existing Customer");
		int userId = sc.nextInt();
		if(adao.chechUser(userId))
		{
			accountmaster(userId);
		}
		else
			System.out.println("No such User. Please add user to continue.");
	}

	private void addNewCustomer() {
		String customer_name, Email, Address, Pancard;
		
		String login_password;
		System.out.println("Enter Customer Name: ");
		customer_name = sc.next();
		System.out.println("Enter Email id: ");
		Email = sc.next();
		System.out.println("Enter Address: ");
		//
		Address = sc.next();
		System.out.println("Enter Pan Card Number: ");
		Pancard = sc.next();
		
		login_password="1asd40#";
		String lock_status = "o";
		
		Customer cust = new Customer(Pancard,customer_name, Email, Address );
		adao.addCustomer(cust);
		
		UserTable ut = new UserTable();
		ut.setLogin_password(login_password);
		ut.setPancard(Pancard);
		ut.setLock_status(lock_status);
		adao.addUser(ut);
		accountmaster(ut.getUser_id());
	}

	public void accountmaster(int user_id) {
		String Account_Type;
		double Account_Balance;
		System.out.println("Enter the Account Type: ");
		Account_Type=sc.next();
		System.out.println("Enter the Account Balance: ");
		Account_Balance=sc.nextDouble();
		Calendar currenttime = Calendar.getInstance();
	    Date sqldate = new Date((currenttime.getTime()).getTime());
		AccountMaster am = new AccountMaster();
		am.setAccount_Type(Account_Type);
		am.setAccount_Balance(Account_Balance);
		am.setOpen_date(sqldate);
		am.setUser_ID(user_id);
		adao.addAccount(am);
	}
	
}
