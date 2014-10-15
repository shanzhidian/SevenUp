package org.sevenup.core.events.account;

import java.util.Date;
import java.util.UUID;


public class AccountDetails {
	private String accountId;
	private UUID key;
	private Date dateTimeOfRegister;
	
	public AccountDetails(){
		accountId = null;
		key = null;
	}
	
	public AccountDetails(UUID key){
		this.key = key;
	}

	public Date getDateTimeOfRegister() {
		return dateTimeOfRegister;
	}

	public void setDateTimeOfRegister(Date dateTimeOfRegister) {
		this.dateTimeOfRegister = dateTimeOfRegister;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public UUID getKey() {
		return key;
	}

	public void setKey(UUID key) {
		this.key = key;
	}
	
	
}
