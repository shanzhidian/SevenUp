package org.sevenup.core.repository;

import java.util.UUID;

import org.sevenup.rest.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, UUID>{

}
