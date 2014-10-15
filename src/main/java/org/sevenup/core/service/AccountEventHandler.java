package org.sevenup.core.service;

import org.sevenup.core.events.account.AccountCreatedEvent;
import org.sevenup.core.events.account.CreateAccountEvent;
import org.sevenup.core.repository.AccountRepository;
import org.sevenup.rest.domain.Account;

public class AccountEventHandler implements AccountService{
	private final AccountRepository accountRepository;

	public AccountEventHandler(final AccountRepository accountRepository){
		this.accountRepository = accountRepository;
	}
	
	@Override
	public AccountCreatedEvent createAccount(CreateAccountEvent createAccountEvent) {
		Account account = Account.fromAccountDetails(createAccountEvent.getAccountDetails());
		account = accountRepository.save(account);
		return new AccountCreatedEvent(account.getKey(), account.toAccountDetails());
	}
	
}
