package com.cg.bs.dao;

import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.UserTable;

public interface AdminDao {
	public void addCustomer(Customer cust);

	public void addUser(UserTable ut);

	public void addAccount(AccountMaster am);
}
