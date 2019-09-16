package com.accounts.datamanager;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.accounts.model.AccountTransaction;

/**
 * /**
 * This is the JPA respoitory for transaction entity, it has got methods to get the data from account_transaction table
 *
 */
public interface TransactionRepository extends CrudRepository<AccountTransaction, Long>{
	
	@Query(value = "Select * from account_transaction where account_number = ?1",nativeQuery = true)
	public List<AccountTransaction> findTransactionsForAccount(Long accountNumber);

}
