package org.sevenup.core.service.general;

import org.sevenup.core.events.account.AccountReadEvent;
import org.sevenup.core.events.account.RequestAccountEvent;

/**
 * 
 * @author steven
 *
 */
public interface AccountService {
	  public AccountReadEvent requestAccount(RequestAccountEvent requestAccountEvent);
}
