package com.cg.bms.ui;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

import com.cg.bms.entities.AccountMaster;
import com.cg.bms.service.BankingService;
import com.cg.bms.service.BankingServiceImpl;

public class Home 
{
	int userName;
	String password;
	static BankingService bSer = new BankingServiceImpl();
	
	
	
	public static void main(String args[])
	//public void Home(int userName)
	{
		//choice variables
		int acChoice, opChoice, stChoice;
		
		
		System.out.println("Welcome, "+"1001");
		System.out.println("Your Accounts with XYZ Bank");
		List<Integer> accList = bSer.getUserAccounts(1001);
		for(Integer a:accList)
			System.out.println("1>> "+a);
		
		System.out.println("Choose your Operation:\n");
		System.out.println("1>> View Transaction Statement");
		opChoice=sc.nextInt();
		switch(opChoice)
		{
			case 1: 
				System.out.println("Enter A/c No:");
				System.out.println("1>> Mini Statement");
				System.out.println("2>> Detailed Statement");
				stChoice=sc.nextInt();
		}
	}
}
