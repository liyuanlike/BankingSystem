package com.cg.bs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.UserTable;

public class AdminDaoImpl implements AdminDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public void addCustomer(Customer cust) {
		em.getTransaction().begin();
		em.persist(cust);
		em.getTransaction().commit();
	}

	@Override
	public void addUser(UserTable ut) {
		em.getTransaction().begin();
		em.persist(ut);
		em.getTransaction().commit();
	}

	@Override
	public void addAccount(AccountMaster am) {
		em.getTransaction().begin();
		em.persist(am);
		em.getTransaction().commit();
	}

	@Override
	public boolean chechUser(int userId) {
		em.getTransaction().begin();
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(*) FROM UserTable  WHERE user_id = :id", Long.class);
	    query.setParameter("id", userId);  
	    em.getTransaction().commit();
	    return query.getSingleResult() > 0;
	}
	
}
