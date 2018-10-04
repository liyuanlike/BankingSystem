package com.cg.bs.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.cg.bs.entities.PayeeTable;
import com.cg.bs.entities.ServiceTracker;
import com.cg.bs.entities.Transactions;
import com.cg.bs.service.BankingService;
import com.cg.bs.service.BankingServiceImpl;

public class Home 
{
	static BankingService bSer = new BankingServiceImpl();
	static Scanner sc = new Scanner(System.in);
	
	
	public void UserHome(int userName)
	//public void Home(int userName)
	{
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
			System.out.println("5>> Fund Transfer");
			System.out.println("6>> Change Password");
			System.out.println("9>> Log Out");
			
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
							if(!tnx.isEmpty())
							{
								System.out.println("Tnx ID\tTnx Date\tType\tAmount\tDescription");
								for(Transactions t:tnx)
									System.out.println(t.getTransaction_ID()+"\t"+t.getDateOfTransaction()
														+"\t"+t.getTransactionType()+"\t"+t.getTranAmount()+"\t"+t.getTran_description());
							}
							else
								System.out.println("No Transaction made by you till now.");
							break;
							
						case 2:
							
							acChoice=bSer.getCurrentAcNo(userName);
							System.out.println("Enter Start Date in DD-Mon-YY format:");
							String startDate=sc.next();
							System.out.println("Enter End Date in DD-Mon-YY format:");
							String endDate=sc.next();
							tnx =  bSer.detailedStatement(acChoice,startDate,endDate);
							if(!tnx.isEmpty())
							{
								System.out.println("Tnx ID\tTnx Date\tType\tAmount\tDescription");
								for(Transactions t:tnx)
									System.out.println(t.getTransaction_ID()+"\t"+t.getDateOfTransaction()
														+"\t"+t.getTransactionType()+"\t"+t.getTranAmount()+"\t"+t.getTran_description());
							}
							else
								System.out.println("No Transaction made by you till now.");
							break;
							
						default:
							System.out.println("Invalid Option! Try Again.");
							break;
					}
					break;
					
				case 2:
					System.out.println("Your Current Address:");
					System.out.println(bSer.getCurrentAddress(userName));
					System.out.println("Enter your Current Address:");
					System.out.println(bSer.updateAddress(userName));
					break;
					
				case 3:
					acChoice=bSer.getCurrentAcNo(userName);
					System.out.println(bSer.chequeRequest(acChoice));
					break;
					
				case 4:
					System.out.println("Do you have Service Request ID: press 1 for 'YES' and 2 for 'NO'");
					switch(sc.nextInt())
					{
						case 1:
							System.out.println("Enter Service Request ID:");
							List<ServiceTracker> serTracker = bSer.getServiceRequestById(userName, sc.nextInt());
							if(serTracker.isEmpty())
							{
								System.out.println("Entered wrong Service Request ID.");
							}
							else
							{
								System.out.println("Service ID\tAccount ID\tStatus\tDescription");
								for(ServiceTracker s:serTracker)
								{
									System.out.println(s.getService_ID()+"\t\t"+s.getAccount_ID()+"\t\t"+s.getService_status()+"\t"+s.getService_Description());
								}
							}
							break;
						case 2:
							System.out.println("You would like to view the services requested by you for A/c No.");
							acChoice=bSer.getCurrentAcNo(userName);
							List<ServiceTracker> serviceRqst=bSer.getAllServiceRequested(acChoice);
							if(!serviceRqst.isEmpty())
							{
								System.out.println("Service ID\tAccount ID\tStatus\tDescription");
								for(ServiceTracker s:serviceRqst)
								{
									System.out.println(s.getService_ID()+"\t\t"+s.getAccount_ID()+"\t\t"+s.getService_status()+"\t"+s.getService_Description());
								}
							}
							else
								System.out.println("You have made no request till now.");
							break;
						default:
							System.out.println("Invalid option! Try again...");
					}
					break;
					
					
				case 5:
					int fromAcChoice,toAcChoice,amt;
					String tnxPassword;
					System.out.println("U would like to transfer fund to your own account or to others:\n press 1:transfer fund to self\n press 2:transfer fund to others");
					switch (sc.nextInt()) 
					{
						case 1:
							
							System.out.println("Enter your beneficiary account");
							toAcChoice=bSer.getCurrentAcNo(userName);
							do
							{
								System.out.println("you would like to transfer ammount from");
								fromAcChoice=bSer.getCurrentAcNo(userName);
								if(toAcChoice==fromAcChoice)
									System.out.println("You have selected same Account no.");
							}while(toAcChoice==fromAcChoice);
							System.out.println("Enter fund amount you want to transfer");
							amt=sc.nextInt();
							System.out.println("Enter the transaction password");
							tnxPassword=sc.next();
							while(!bSer.checkTransactionPassword(userName,tnxPassword))
							{
									System.out.println("Wrong transaction password\n Enter valid transaction password");
									tnxPassword=sc.next();
							}
							bSer.checkBalanceAndMakeTransaction(toAcChoice,fromAcChoice,amt);
							break;
						case 2:
							System.out.println("Press 1 to Add a new Payee\nPress 2 to Make a Transfer using Registered Payee a/c");
							switch(sc.nextInt())
							{
								case 1:
									System.out.println(bSer.validateAndCreatePayeeAccount(userName));
									break;
								case 2:
									List<PayeeTable> payeeList = bSer.getPayeeAccountId(userName);
									if(!payeeList.isEmpty())
									{
										List<Integer> payeeAcs = new ArrayList<Integer>();
										System.out.println("Payee A/c No. \tNick Name");
										for(PayeeTable p:payeeList)
										{
											System.out.println(p.getPayee_Account_Id()+"\t\t"+p.getNick_name());			
											payeeAcs.add(p.getPayee_Account_Id());
										}
										do
										{
											System.out.println("Enter a Registered Payee Account:");
											toAcChoice=sc.nextInt();
										}while(!payeeAcs.contains(toAcChoice));
										System.out.println("you would like to transfer ammount from");
										fromAcChoice=bSer.getCurrentAcNo(userName);
										System.out.println("Enter fund amount you want to transfer");
										amt=sc.nextInt();
										System.out.println("Enter the transaction password");
										tnxPassword=sc.next();
										while(!bSer.checkTransactionPassword(userName,tnxPassword))
										{
												System.out.println("Wrong transaction password\n Enter valid transaction password");
												tnxPassword=sc.next();
										}
										bSer.checkBalanceAndMakeTransaction(toAcChoice,fromAcChoice,amt);
									}
									else
										System.out.println("No Payee details found. Create One.");
									break;
									
								default:
									break;	
							}
							break;
					}
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
					System.out.println("Thank You.\nYou have successfully logged out.");
					System.exit(0);
					
				default:
					System.out.println("Invalid Option! Try Again...");
			}
		}
	}
}
