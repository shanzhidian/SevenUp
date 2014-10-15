package org.sevenup.core.events.account;

import org.sevenup.core.events.CreateEvent;

public class CreateAccountEvent extends CreateEvent{
	private AccountDetails accountDetails;
	
	public CreateAccountEvent(AccountDetails accountDetails){
		this.accountDetails = accountDetails;
	}
	
	public AccountDetails getAccountDetails(){
		return accountDetails;
	}
}
