package com.cg.bs.service;

import java.util.Scanner;

import com.cg.bs.dao.LoginDao;
import com.cg.bs.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	LoginDao ldao = new LoginDaoImpl();
	Scanner sc = new Scanner(System.in);
	@Override
	public boolean verifyCredentials(int username, String password, String role) {
		return ldao.verifyCredentials(username, password, role);
	}

	@Override
	public void login() {
		int username;
		String password,role;
		boolean flag;
		String check;
		for(int i=1; i<=3; i++)
		{
			System.out.println("Enter Username: ");
			username = sc.nextInt();
			System.out.println("Enter Password: ");
			password = sc.next();
			System.out.println("Enter your role: admin/user");
			role=sc.next();
			flag = verifyCredentials(username, password,role);
			if(flag == true)
			{
				check = ldao.checklockstatus(username, password);
				if(check.equals("o"))
				{
					System.out.println("Successful");
					break;
				}
				else
				{
					System.out.println("Account is Locked"+"\nPlease contact your bank");
					break;
				}
			}
			else if(i<=2)
			{
				System.out.println("Invalid User Name or Password");
				continue;
			}
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

}
