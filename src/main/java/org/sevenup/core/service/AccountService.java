package org.sevenup.core.service;

import org.sevenup.core.events.account.AccountCreatedEvent;
import org.sevenup.core.events.account.CreateAccountEvent;

public interface AccountService {
	public AccountCreatedEvent createAccount(CreateAccountEvent createUserEvent);
	//public UserDeltetedEvent deleteUser(DeleteUserEvent deleteUseEvent);
	//public UserUpdatedEvent setUser(SetUserEvent setUserEvent);
	//public AllUsersEvent requestAllUsers(RequestAllUsersEvent requestAllUsersEvent);
}
