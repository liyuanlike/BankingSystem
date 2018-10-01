package com.cg.bms.service;

import java.util.List;

import com.cg.bms.entities.AccountMaster;
import com.cg.bms.entities.ServiceTracker;
import com.cg.bms.entities.Transactions;

public interface BankingService 
{
	public boolean validateUser(int userName, String password);
	public List<Integer> getUserAccounts(int userName);
	public List<Transactions> miniStatement(int accNo);
	public List<Transactions> detailedStatement(int accNo,String startDate,String endDate);
	public int getCurrentAcNo(int userName);
	public String changeAddress(int userName);
	public String changePassword(int userName,String oldPass,String newPass);
	public String chequeRequest(int accNo);
	public List<ServiceTracker> getAllServiceRequested(int accNo);
}
