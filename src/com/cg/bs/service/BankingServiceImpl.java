package com.cg.bms.service;

import java.util.List;


import java.util.Scanner;

import com.cg.bms.dao.BankingDao;
import com.cg.bms.dao.BankingDaoImpl;
import com.cg.bms.entities.AccountMaster;
import com.cg.bms.entities.PayeeTable;
import com.cg.bms.entities.ServiceTracker;
import com.cg.bms.entities.Transactions;

public class BankingServiceImpl implements BankingService
{
	BankingDao bDao = new BankingDaoImpl();
	Scanner sc = new Scanner(System.in);
	public boolean validateUser(int userName, String password)
	{
		return bDao.validateUser(userName,password);
	}
	
	public List<Integer> getUserAccounts(int userName)
	{
		return bDao.getUserAccounts(userName);
	}

	@Override
	public List<Transactions> miniStatement(int accNo) 
	{
		return bDao.miniStatement(accNo);
	}

	@Override
	public List<Transactions> detailedStatement(int accNo, String startDate,String endDate) 
	{
		return bDao.detailedStatement(accNo, startDate, endDate);
	}
	
	public int getCurrentAcNo(int userName)
	{
		//fetching all the accounts of current user -- here its 1001
				List<Integer> accList = getUserAccounts(userName);
				for(Integer a:accList)
					System.out.println(a);
				
				//storing the ac no. for which the user requested for operations
				System.out.println("Enter Account Number you want to proceed with");
				int acChoice=sc.nextInt();
				while(!accList.contains(acChoice))
				{
					System.out.println("Sorry You entered wrong Account Number\nEnter Valid Account Number:");
					acChoice=sc.nextInt();
				}
				return acChoice;
	}
	public String getCurrentAddress(int userName)
	{
		return bDao.getCurrentAddress(userName);
	}
	public String updateAddress(int userName)
	{
		return bDao.updateAddress(userName);
	}
	
	public String changePassword(int userName,String oldPass,String newPass)
	{
		return bDao.changePassword(userName,oldPass,newPass);
	}
	
	public String chequeRequest(int accNo)
	{
		return bDao.chequeRequest(accNo);
	}

	@Override
	public List<ServiceTracker> getAllServiceRequested(int accNo) 
	{
		return bDao.getAllServiceRequested(accNo);
	}

	@Override
	public List<ServiceTracker> getServiceRequestById(int userName, int requestID) 
	{
		return bDao.getServiceRequestById(userName, requestID);
	}
	public int getAcAvailableBalance(int fromAcChoice,int amt)
	{
		return bDao.getAcAvailableBalance(fromAcChoice, amt);
	}
	public int fundTransfer(int toAcChoice,int fromAcChoice,int amt)
	{
		return bDao.fundTransfer(toAcChoice,fromAcChoice, amt);
	}
	public List<PayeeTable> getPayeeAccountId(int userName)
	{
		return bDao.PayeeAccountId(userName);
	}
	public String addPayee(int user_id,int payee_account_id,String nickname)
	{
		return bDao.addPayee(user_id,payee_account_id,nickname);
	}
	public boolean isAccountExist(int account_no, int userName)
	{
		return bDao.isAccountExist(account_no,userName);
	}
	public int getURN()
	{
		return (int)(Math.random()*10000);
	}
	public String validateAndCreatePayeeAccount(int userName)
	{
		System.out.println("Enter Payee Account Id");
		int toAc;
		do
		{
			toAc=sc.nextInt();
			if(!isAccountExist(toAc,userName))
				System.out.println("No such account exist. Enter valid Ac no");
		}while(!isAccountExist(toAc,userName));
		int sysURN, userURN;
		do
		{
			sysURN=getURN();
			System.out.println("URN: "+sysURN+"\nEnter Displayed URN:");
			userURN=sc.nextInt();
			if(sysURN!=userURN)
				System.out.println("Invalid URN! Try again...");
		}while(sysURN!=userURN);
		System.out.println("Enter payee nickname");
		return "Payee added: "+addPayee(userName,toAc,sc.next());
	}
	
	public void checkBalanceAndMakeTransaction(int toAcChoice,int fromAcChoice,int amt)
	{
		if(amt<=getAcAvailableBalance(fromAcChoice,amt))
		{
			System.out.println("Fund transfer to Account No "+toAcChoice
					+"from Account No. "+fromAcChoice+"\nCurrent Balance of Account No. "
					+fromAcChoice+" is "+fundTransfer(toAcChoice, fromAcChoice, amt));
		}
		else
		{
			System.out.println("Insufficient Balance");
		}
	}
	
	public boolean checkTransactionPassword(int userName, String tnxPassword)
	{
		return bDao.checkTransactionPassword(userName,tnxPassword);
	}
}
