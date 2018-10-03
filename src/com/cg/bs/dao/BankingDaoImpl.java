package com.cg.bms.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.bms.entities.AccountMaster;
import com.cg.bms.entities.Customer;
import com.cg.bms.entities.PayeeTable;
import com.cg.bms.entities.ServiceTracker;
import com.cg.bms.entities.Transactions;
import com.cg.bms.entities.UserTable;


public class BankingDaoImpl implements BankingDao
{
	Scanner sc=new Scanner(System.in);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	@Override
	public boolean validateUser(int userName, String password) 
	{
		return true;
	}

	@Override
	public List<Integer> getUserAccounts(int userName) 
	{
		String query="Select a.Account_ID from AccountMaster a where a.User_ID="+userName;
		TypedQuery<Integer> jpql = em.createQuery(query, Integer.class);
		List<Integer> accList = jpql.getResultList();
		return accList;
	}

	@Override
	public List<Transactions> miniStatement(int accNo) 
	{
		String query ="select t from Transactions t where t.Account_No="+accNo+" order by t.Transaction_ID desc";
		TypedQuery<Transactions> jpql=em.createQuery(query, Transactions.class);
		List<Transactions> temp = jpql.getResultList();
		List<Transactions> tnx = new ArrayList<Transactions>();
		if(temp.size()>10)
		{
			for(int i=0; i<10;i++)
				tnx.add(temp.get(i));
			return tnx;
		}
		else
			return temp;
	}

	@Override
	public List<Transactions> detailedStatement(int accNo, String startDate, String endDate) 
	{
		String query ="select t from Transactions t where t.Account_No = "+accNo+" and t.DateOfTransaction between '"+startDate+"' and '"
				+endDate+"' order by t.Transaction_ID desc";
		TypedQuery<Transactions> jpql=em.createQuery(query, Transactions.class);
		List<Transactions> tnx = jpql.getResultList();
		return tnx;
	}
	
	public String getCurrentAddress(int userName)
	{
		UserTable user = em.find(UserTable.class,userName);
		String pc=user.getPancard();
		Customer cust=em.find(Customer.class,pc);
		return cust.getAddress();
		
	}
	
	public String updateAddress(int userName)
	{
		UserTable user = em.find(UserTable.class,userName);
		String pc=user.getPancard();
		Customer cust=em.find(Customer.class,pc);
		cust.setAddress(sc.nextLine());
		em.getTransaction().begin();
		em.merge(cust);
		em.getTransaction().commit();
		return "Address Updated...";
	}

	@Override
	public String changePassword(int userName, String oldPass, String newPass) 
	{
		UserTable user = em.find(UserTable.class,userName);
		String pass=user.getLogin_Password();
		if(oldPass.equals(pass))
		{
			user.setLogin_Password(newPass);
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			return "Password Changed";
		}
		return "Wrong Password";
	}

	@Override
	public String chequeRequest(int accNo) 
	{
		ServiceTracker chqRqst = new ServiceTracker(accNo,"New Cheque Request","Open");
		em.getTransaction().begin();
		em.persist(chqRqst);
		em.getTransaction().commit();
		return "Request Accepted. Your Service ID: "+chqRqst.getService_ID();
	}

	@Override
	public List<ServiceTracker> getAllServiceRequested(int accNo) 
	{
		String query ="Select t from ServiceTracker t where t.Account_ID="+accNo;
		TypedQuery<ServiceTracker> jpql=em.createQuery(query, ServiceTracker.class);
		List<ServiceTracker> serTracker = jpql.getResultList();
		return serTracker;
	}

	@Override
	public List<ServiceTracker> getServiceRequestById(int userName, int requestID) 
	{
		String query ="Select t from ServiceTracker t where t.Service_ID="+requestID
				+" and t.Account_ID IN(Select a from AccountMaster a where a.User_ID="+userName+")";
		TypedQuery<ServiceTracker> jpql = em.createQuery(query, ServiceTracker.class);
		List<ServiceTracker> serTracker = jpql.getResultList();
		return serTracker;
	}
	
	public int getAcAvailableBalance(int fromAcChoice,int amt)
	{
		AccountMaster am = em.find(AccountMaster.class,fromAcChoice);
		return am.getAccount_Balance();
	}
	public boolean checkTransactionPassword(int userName, String tnxPassword)
	{
		UserTable user = em.find(UserTable.class,userName);
		if(user.getTransaction_Password().equals(tnxPassword))
			return true;
		else
			return false;
	}
	public int fundTransfer(int toAcChoice,int fromAcChoice,int amt)
	{
		em.getTransaction().begin();
		Transactions debit=new Transactions(amt,fromAcChoice,"Transfer to account number "+toAcChoice,"d");
		em.persist(debit);
		AccountMaster am = em.find(AccountMaster.class,fromAcChoice);
		am.setAccount_Balance(am.getAccount_Balance()-amt);
		em.merge(am);
		int currBalance=am.getAccount_Balance();
		Transactions credit=new Transactions(amt,toAcChoice,"Transfer from account number "+fromAcChoice,"c");
		em.persist(credit);
		am = em.find(AccountMaster.class,toAcChoice);
		am.setAccount_Balance(am.getAccount_Balance()+amt);
		em.merge(am);
		em.getTransaction().commit();
		return currBalance;
	}
	
	public List<PayeeTable> PayeeAccountId(int userName)
	{
		String query="Select p from PayeeTable p where p.User_Id="+userName;
		TypedQuery<PayeeTable> jpql = em.createQuery(query, PayeeTable.class);
		List<PayeeTable> payeeList = jpql.getResultList();
		return payeeList;
	}
	
	public boolean isAccountExist(int account_no, int userName)
	{
		String query="Select a.Account_ID from AccountMaster a where a.Account_ID="+account_no+" and a.User_ID<>"+userName;
		TypedQuery<Integer> jpql = em.createQuery(query, Integer.class);
		List<Integer> payeeAc = jpql.getResultList();
		if(payeeAc.isEmpty())
			return false;
		else
			return true;
	}
	public String addPayee(int user_id,int payee_account_id,String nickname)
	{
		em.getTransaction().begin();
		PayeeTable pt=new PayeeTable(user_id,payee_account_id,nickname);
		em.persist(pt);
		em.getTransaction().commit();
		return payee_account_id+nickname;
	}
}