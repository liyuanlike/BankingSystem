package com.cg.bms.service;

import java.util.List;

import com.cg.bms.dao.BankingDao;
import com.cg.bms.dao.BankingDaoImpl;
import com.cg.bms.entities.AccountMaster;

public class BankingServiceImpl implements BankingService
{
	BankingDao bDao = new BankingDaoImpl();
	public boolean validateUser(int userName, String password)
	{
		return bDao.validateUser(userName,password);
	}
	
	public List<Integer> getUserAccounts(int userName)
	{
		return bDao.getUserAccounts(userName);
	}
}
