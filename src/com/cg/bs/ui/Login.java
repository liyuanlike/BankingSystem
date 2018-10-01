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
		System.out.println("Select Your choice: "+"\n1)Login"+"\n2)Forgot Password");
		choice = sc.nextInt();
		switch(choice)
		{
		
			case 1: lser.login();
					break;
			case 2: 
				    int username;
				    System.out.println("Enter Username: ");
					username = sc.nextInt();
					lser.forgotPassword(username);
					break;
			default:System.out.println("Invalid Input");
		}
  }
}