package com.cg.bs.service;

import java.util.List;

import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.Transactions;
import com.cg.bs.entities.UserTable;

public interface AdminService {


	boolean chechUser(int userId);

	List<Transactions> getPeriodicalTransaction(String startDate, String endDate);

	void addCustomer(Customer cust);

	void addUser(UserTable ut);

	void addAccount(AccountMaster am);
	
}
