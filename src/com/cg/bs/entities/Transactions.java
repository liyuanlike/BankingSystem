package com.cg.bs.entities;

import java.sql.Date;

public class Transactions {

	private int Transaction_ID, TranAmount, Account_No;
	private String Tran_description, TransactionType;
	Date DateofTransaction;
	
	public int getTransaction_ID() {
		return Transaction_ID;
	}
	public void setTransaction_ID(int transaction_ID) {
		Transaction_ID = transaction_ID;
	}
	
	
	public int getTranAmount() {
		return TranAmount;
	}
	public void setTranAmount(int tranAmount) {
		TranAmount = tranAmount;
	}
	
	
	public int getAccount_No() {
		return Account_No;
	}
	public void setAccount_No(int account_No) {
		Account_No = account_No;
	}
	
	
	public String getTran_description() {
		return Tran_description;
	}
	public void setTran_description(String tran_description) {
		Tran_description = tran_description;
	}
	
	
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	
	
	@Override
	public String toString() {
		return "Transactions [Transaction_ID=" + Transaction_ID
				+ ", TranAmount=" + TranAmount + ", Account_No=" + Account_No
				+ ", Tran_description=" + Tran_description
				+ ", TransactionType=" + TransactionType + "]";
	}
	
	

	
	
	public Date getDateofTransaction() {
		return DateofTransaction;
	}
	public void setDateofTransaction(Date dateofTransaction) {
		DateofTransaction = dateofTransaction;
	}
	public Transactions(int transaction_ID, int tranAmount, int account_No,
			String tran_description, String transactionType,
			Date dateofTransaction) {
		super();
		Transaction_ID = transaction_ID;
		TranAmount = tranAmount;
		Account_No = account_No;
		Tran_description = tran_description;
		TransactionType = transactionType;
		DateofTransaction = dateofTransaction;
	}
	public Transactions() {
		super();
	}
	
}
