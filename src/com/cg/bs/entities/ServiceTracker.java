package com.cg.bs.entities;

import java.sql.Date;

public class ServiceTracker {

	private int Service_ID, Account_ID;
	private String Service_Description, Service_status;
	Date Service_Raised_Date;
	
	public ServiceTracker() {
		super();
	}

	public ServiceTracker(int service_ID, int account_ID,
			String service_Description, String service_status,
			Date service_Raised_Date) {
		super();
		Service_ID = service_ID;
		Account_ID = account_ID;
		Service_Description = service_Description;
		Service_status = service_status;
		Service_Raised_Date = service_Raised_Date;
	}

	@Override
	public String toString() {
		return "ServiceTracker [Service_ID=" + Service_ID + ", Account_ID="
				+ Account_ID + ", Service_Description=" + Service_Description
				+ ", Service_status=" + Service_status
				+ ", Service_Raised_Date=" + Service_Raised_Date + "]";
	}

	public int getService_ID() {
		return Service_ID;
	}

	public void setService_ID(int service_ID) {
		Service_ID = service_ID;
	}

	public int getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
	}

	public String getService_Description() {
		return Service_Description;
	}

	public void setService_Description(String service_Description) {
		Service_Description = service_Description;
	}

	public String getService_status() {
		return Service_status;
	}

	public void setService_status(String service_status) {
		Service_status = service_status;
	}

	public Date getService_Raised_Date() {
		return Service_Raised_Date;
	}

	public void setService_Raised_Date(Date service_Raised_Date) {
		Service_Raised_Date = service_Raised_Date;
	}
	
	
	
}
