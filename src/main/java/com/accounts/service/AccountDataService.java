package com.accounts.service;

import java.util.List;

import com.accounts.model.Account;
import com.accounts.model.AccountTransactionOutput;

/**
 * This class is business service to handle any CRUD operations with accounts, transactions.
 *
 */
public interface AccountDataService {
	
	public List<Account> getAccounts();
	
	public List<AccountTransactionOutput> getTransactions(Long accountNumber);
	
	public void saveAccounts();

}
