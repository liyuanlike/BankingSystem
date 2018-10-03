package com.cg.bs.ui;

import java.util.Scanner;

import com.cg.bs.service.LoginService;
import com.cg.bs.service.LoginServiceImpl;

public class Login {

	
	static LoginService lser = null;
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		int choice;
		lser = new LoginServiceImpl();
		System.out.println("Select your choice: "+"\n1)Login"+"\n2)Forgot Password");
		choice = sc.nextInt();
		switch(choice)
		{
		
			case 1: System.out.println("You are ?"+"\n1)Admin"+"\n2)User");
					int role = sc.nextInt();
					switch(role)
					{
						case 1: lser.Adminlogin();
								break;
						case 2: lser.Userlogin();
								break;
						default: System.out.println("Invalid Input");
								 break;
					}
					break;
			 
			case 2:	int username;
				    System.out.println("Enter Username: ");
					username = sc.nextInt();
					lser.forgotPassword(username);
					break;
					
			default: System.out.println("Invalid Input");
					 break;
		}
  }
}