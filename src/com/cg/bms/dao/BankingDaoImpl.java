package com.cg.bms.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.bms.entities.AccountMaster;

public class BankingDaoImpl implements BankingDao
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	Scanner sc = new Scanner(System.in);
	@Override
	public boolean validateUser(int userName, String password) 
	{
		return true;
	}

	@Override
	public List<Integer> getUserAccounts(int userName) 
	{
		String query="Select a.Account_ID from AccountMaster a where a.User_ID=1001";
		TypedQuery<Integer> jpql = em.createQuery(query, Integer.class);
		//jpql.setParameter("userName",userName);
		List<Integer> accList = jpql.getResultList();
		return accList;
	}

}
