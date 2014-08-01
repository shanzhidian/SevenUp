package org.sevenup.core.service.general;

import org.sevenup.core.events.account.AccountReadEvent;
import org.sevenup.core.events.account.RequestAccountEvent;
import org.sevenup.rest.domain.Account;

public class AccountEventHandler implements AccountService{

	public AccountReadEvent requestAccount(RequestAccountEvent requestAccountEvent) {
		AccountReadEvent accountReadEvent = new AccountReadEvent();
		Account account = requestAccountEvent.getAccount();
		if(account.getEmail().equals("nonumber1989@gmail.com")&&account.getPassword().equals("nonumber1989")){
			accountReadEvent.setCorrect(true);
		}
		return accountReadEvent;
	}

}
