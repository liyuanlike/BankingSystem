package com.cg.bs.ui;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.Transactions;
import com.cg.bs.entities.UserTable;
import com.cg.bs.service.AdminService;
import com.cg.bs.service.AdminServiceImpl;
import com.cg.bs.service.LoginService;
import com.cg.bs.service.LoginServiceImpl;

public class Login {

	
	static LoginService lser =  new LoginServiceImpl();
	static AdminService aser = new AdminServiceImpl();
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		int choice;
		
		System.out.println("Select your choice: "+"\n1)Login"+"\n2)Forgot Password");
		choice = sc.nextInt();
		switch(choice)
		{
		
			case 1: System.out.println("You are ?"+"\n1)Admin"+"\n2)User");
					int role = sc.nextInt();
					switch(role)
					{
						case 1: Adminlogin();
								break;
						case 2: Userlogin();
								break;
						default: System.out.println("Invalid Input");
								 break;
					}
					break;
			 
			case 2:	int username;
				    System.out.println("Enter Username: ");
					username = sc.nextInt();
					forgotPassword(username);
					break;
					
			default: System.out.println("Invalid Input");
					 break;
		}
  }
	
	// When User Forgets Password check for Secret Answer and provide pwd via email.
	public static void forgotPassword(int username) {
		System.out.println("Answer your Secret Question: ");
		
		String ans = sc.next();
		String db_ans = lser.checkSecretAns(username);
		if(db_ans.equals(ans))
		{
			lser.setpassword(username, "sbq500#");
			System.out.println("Password has been sent to your registered email-id.");
		}
		else
			System.out.println("Invalid User");
		
	}


	public static void Adminlogin() {
			int Id;
			String password;
			System.out.println("Enter Admin Id: ");
			Id = sc.nextInt();
			System.out.println("Enter Password: ");
			password = sc.next();
			boolean flag = lser.adminLogin(Id, password);
			if(flag)
			{
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
			else
				System.out.println("Invalid Credentials");
	}

	
	public static void getPeriodicalTransaction() 
	{
		System.out.println("Enter Start Date in DD-Mon-YY format:");
		String startDate=sc.next();
		System.out.println("Enter End Date in DD-Mon-YY format:");
		String endDate=sc.next();
		List<Transactions> tnx = aser.getPeriodicalTransaction(startDate, endDate);
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

	 public static void addAccount() {
		System.out.println("Enter User_Id of existing Customer");
		int userId = sc.nextInt();
		if(aser.chechUser(userId))
		{
			accountmaster(userId);
		}
		else
			System.out.println("No such User. Please add user to continue.");
	}

	public static void addNewCustomer() {
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
		aser.addCustomer(cust);
		
		UserTable ut = new UserTable();
		ut.setLogin_password(login_password);
		ut.setPancard(Pancard);
		ut.setLock_status(lock_status);
		aser.addUser(ut);
		accountmaster(ut.getUser_id());
	}

	public static void accountmaster(int user_id) {
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
		aser.addAccount(am);
	}

	public static void Userlogin() {
			int username;
			String password;
			boolean flag;
			String check;
			
			//User is given three chances for login.
			for(int i=1; i<=3; i++)
			{
				System.out.println("Enter Username: ");
				username = sc.nextInt();
				System.out.println("Enter Password: ");
				
				password = sc.next();
				flag = lser.verifyCredentials(username, password);
				
				//When User-id & Password is correct
				if(flag == true)
				{
					
					// Check Lock status of account whether open / blocked
					check = lser.checklockstatus(username, password);
					
					//When account lock-status is open
					if(check.equals("o"))
					{
						//Check if password is default forgot password then allow user to change the password. 
						if(password.equals("sbq500#"))
						{
							System.out.println("Enter new password: ");
							
							String new_pass = sc.next();
							System.out.println();
							System.out.println("Confirm new password: ");
							
							String new_pass_conf = sc.next();
							
							//Confirm the new entered Password 
							if(new_pass.equals(new_pass_conf))
							{
								lser.setpassword(username, new_pass);
								System.out.println("Passowrd updated");
							}
							else 
							{
								System.out.println("Password did not match");
								continue;
							}
							break;
						}
						
						else if(password.equals("1asd40#"))
						{
							UserTable ut = new UserTable();
							System.out.println("Enter Secret Question's Answer: ");
							String ans = sc.next();
							ut.setSecret_question(ans);
							System.out.println("Enter new Login password: ");
							String new_pass = sc.next();
							System.out.println("Confirm new Login password: ");
							String new_pass_conf = sc.next();
							
							System.out.println("Enter new Transaction password: ");
							String tranx_pass = sc.next();
							System.out.println("Confirm new Transaction password: ");
							String new_tranx_conf = sc.next();
							//Confirm the new entered Password 
							if(new_pass.equals(new_pass_conf) && tranx_pass.equals(new_tranx_conf))
							{
								ut.setLogin_password(new_pass);
								ut.setTransaction_password(tranx_pass);
								lser.updateUser(ut, username);
								System.out.println("Account Updated");
								break;
							}
							else 
							{
								System.out.println("Password did not match");
								continue;
							}
						}
						
						// User-id & Password is correct.
						else
						{
							System.out.println("Welcome "+username+" to Banking System");
							Home uh = new Home();
							uh.UserHome(username);
							break;
						}
					}
					
					//When account lock-status is blocked.
					else
					{
						System.out.println("Account is Locked"+"\nPlease contact your bank");
						break;
					}
					
				}
				
				//Failed attempts of login.
				else if(i<=2)
				{
					System.out.println("Invalid User Name or Password");
					continue;
				}
				
				//Three wrong attempts will block the account.
				else
				{
					lser.lockAccount(username); 
					System.out.println("3 wrong attempts. Account is locked.");
					break;
				}
					
			}
			
		}
		
}