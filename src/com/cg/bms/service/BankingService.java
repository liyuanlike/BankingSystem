package com.cg.bms.service;

import java.util.List;

import com.cg.bms.entities.AccountMaster;

public interface BankingService 
{
	public boolean validateUser(int userName, String password);
	public List<Integer> getUserAccounts(int userName);
}
