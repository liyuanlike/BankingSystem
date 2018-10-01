package com.cg.bms.service;

import java.util.List;


import java.util.Scanner;

import com.cg.bms.dao.BankingDao;
import com.cg.bms.dao.BankingDaoImpl;
import com.cg.bms.entities.AccountMaster;
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
	
	public String changeAddress(int userName)
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
}
