package com.cg.bms.dao;

import java.util.List;
import java.util.Scanner;






import com.cg.bms.entities.AccountMaster;
import com.cg.bms.entities.ServiceTracker;
import com.cg.bms.entities.Transactions;

public interface BankingDao 
{
	public boolean validateUser(int userName, String password);
	public List<Integer> getUserAccounts(int userName);
	
	public List<Transactions> miniStatement(int accNo);
	public List<Transactions> detailedStatement(int accNo,String startDate,String endDate);
	
	public String updateAddress(int userName);
	public String changePassword(int userName,String oldPass,String newPass);
	
	public String chequeRequest(int accNo);
	
	public List<ServiceTracker> getAllServiceRequested(int accNo);
}
