package com.cg.bms.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

import com.cg.bms.entities.AccountMaster;
import com.cg.bms.entities.ServiceTracker;
import com.cg.bms.entities.Transactions;
import com.cg.bms.service.BankingService;
import com.cg.bms.service.BankingServiceImpl;

public class Home 
{
	static BankingService bSer = new BankingServiceImpl();
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String args[])
	//public void Home(int userName)
	{
		int userName=1001;
		int acChoice;		//to store ac no on which operations to be operated
		List<Transactions> tnx;
		
		System.out.println("Welcome, "+userName);
		
		while(true)
		{
			//operation list
			System.out.println("\n\nChoose your Operation:");
			System.out.println("1>> View Transaction Statement");
			System.out.println("2>> Change Address");
			System.out.println("3>> Requisition for Cheque Book");
			System.out.println("4>> Track Service Request");
			System.out.println("6>> Change Password");
			System.out.println("9>> Exit");
			
			//switch for operations
			switch(sc.nextInt())
			{
				case 1: 
					System.out.println("1>> Mini Statement\n2>> Detailed Statement");
					switch(sc.nextInt())
					{
						case 1:	
							acChoice=bSer.getCurrentAcNo(userName);
							tnx =  bSer.miniStatement(acChoice);
							System.out.println("Tnx ID\tTnx Date\tA/c No.\tDescription\tType\t Amount");
							for(Transactions t:tnx)
								System.out.println(t.getTransaction_ID()+"\t"+t.getDateOfTransaction()+"\t"+t.getAccount_No()
													+"\t"+t.getTran_description()+"\t"+t.getTransactionType()+"\t"+t.getTranAmount());
							break;
							
						case 2:
							acChoice=bSer.getCurrentAcNo(userName);
							System.out.println("Enter Start Date in DD-Mon-YY format:");
							String startDate=sc.next();
							System.out.println("Enter End Date in DD-Mon-YY format:");
							String endDate=sc.next();
							tnx =  bSer.detailedStatement(acChoice,startDate,endDate);
							for(Transactions t:tnx)
								System.out.println(t.getTransaction_ID()+"\t"+t.getDateOfTransaction()+"\t"+t.getAccount_No()
													+"\t"+t.getTran_description()+"\t"+t.getTransactionType()+"\t"+t.getTranAmount());
							break;
							
						default:
							System.out.println("Invalid Option! Try Again.");
							break;
					}
					break;
					
				case 2:
					System.out.println("Your Current Address:");
					System.out.println(bSer.changeAddress(userName));
					break;
					
				case 3:
					acChoice=bSer.getCurrentAcNo(userName);
					System.out.println(bSer.chequeRequest(acChoice));
					break;
					
				case 4:
					acChoice=bSer.getCurrentAcNo(userName);
					List<ServiceTracker> serviceRqst=bSer.getAllServiceRequested(acChoice);
					for(Transactions s:serviceRqst)
						System.out.println(s);
					break;
					
				case 6:
					System.out.println("Enter your old password");
					String oldPass=sc.next();
					String newPass, newPassC;
					do
					{
						System.out.println("Enter your new password");
						newPass=sc.next();
						System.out.println("Confirm new password");
						newPassC=sc.next();
						if(!newPass.equals(newPassC))
							System.out.println("New Password and Confirm Password did not matched");
					}while(!newPass.equals(newPassC));
					System.out.println(bSer.changePassword(userName,oldPass,newPass));
					break;
					
				case 9:
					System.out.println("Thank You.");
					System.exit(0);
					
				default:
					System.out.println("Invalid Option! Try Again...");
			}
		}
	}
}
