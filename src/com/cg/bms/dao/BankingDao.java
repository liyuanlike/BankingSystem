package com.cg.bms.dao;

import java.util.List;
import java.util.Scanner;


import com.cg.bms.entities.AccountMaster;

public interface BankingDao 
{
	public boolean validateUser(int userName, String password);
	public List<Integer> getUserAccounts(int userName);
}
