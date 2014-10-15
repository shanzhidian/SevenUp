package org.sevenup.core.events.account;

import java.util.UUID;

import org.sevenup.core.events.CreatedEvent;

public class AccountCreatedEvent extends CreatedEvent{
	//private final String accountId;
	private final UUID newAccountKey;
	private final AccountDetails accountDetails;
	
	public AccountCreatedEvent(final UUID newAccountKey,final AccountDetails accountDetails){
		this.newAccountKey = newAccountKey;
		this.accountDetails = accountDetails;
	}

	/*public String getAccountId() {
		return accountId;
	}*/

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public UUID getNewAccountKey() {
		return newAccountKey;
	}
	
	
}
