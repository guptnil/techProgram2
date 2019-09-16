package com.accounts.datamanager;

import org.springframework.data.repository.CrudRepository;

import com.accounts.model.Account;

/**
 * This is the JPA respoitory for account entity
 *
 */
public interface AccountRepository extends CrudRepository<Account, Long>{
	
	

}
