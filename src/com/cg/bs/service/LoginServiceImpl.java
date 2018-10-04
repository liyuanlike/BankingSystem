package com.cg.bs.service;

import java.util.Scanner;

import com.cg.bs.dao.LoginDao;
import com.cg.bs.dao.LoginDaoImpl;
import com.cg.bs.entities.UserTable;
import com.cg.bs.ui.Home;

public class LoginServiceImpl implements LoginService {

	LoginDao ldao = new LoginDaoImpl();
	Scanner sc = new Scanner(System.in);
	
	
	public boolean verifyCredentials(int username, String password) {
		return ldao.verifyCredentials(username, password);
	}

	@Override
	public void Userlogin() {
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
			flag = verifyCredentials(username, password);
			
			//When User-id & Password is correct
			if(flag == true)
			{
				
				// Check Lock status of account whether open / blocked
				check = ldao.checklockstatus(username, password);
				
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
							ldao.setpassword(username, new_pass);
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
							ldao.updateUser(ut, username);
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
				ldao.lockAccount(username); 
				System.out.println("3 wrong attempts. Account is locked.");
				break;
			}
				
		}
		
	}

	@Override
	public void forgotPassword(int username) 
	{
		System.out.println("Answer your Secret Question: ");
		
		String ans = sc.next();
		String db_ans = ldao.checkSecretAns(username);
		if(db_ans.equals(ans))
		{
			ldao.setpassword(username, "sbq500#");
			System.out.println("Password has been sent to your registered email-id.");
		}
		else
			System.out.println("Invalid User");
	}

	@Override
	public void Adminlogin() {
		int Id;
		String password;
		System.out.println("Enter Admin Id: ");
		Id = sc.nextInt();
		System.out.println("Enter Password: ");
		password = sc.next();
		boolean flag = ldao.adminLogin(Id, password);
		if(flag)
		{
			AdminService aSer = new AdminServiceImpl();
			aSer.adminHome();
		}
		else
			System.out.println("Invalid Credentials");
	}
}
