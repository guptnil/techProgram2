package com.accounts.common;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.model.Account;
import com.accounts.model.AccountTransactionOutput;
import com.accounts.service.AccountDataService;

/**
 * This class is Rest controller to serve any requests for accounts or transactions.
 * It returns the information in json format.
 *
 */
@RestController
public class AccountController {
	
	@Autowired
	private AccountDataService accountDataService ; 

	/**
	 * It returns the list of accounts
	 */
	@GetMapping(value="/getAccounts")
	public ResponseEntity<List<Account>> getAccounts() {
		try {
			List<Account> accounts = accountDataService.getAccounts();
			return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Account>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * It returns the list of transactions for a given account number
	 */
	@GetMapping(value="/getTransactions")
	public ResponseEntity<List<AccountTransactionOutput>> getTransactions(@RequestParam("accountNo") String accountNo) {
		try {
			List<AccountTransactionOutput> outputList = accountDataService.getTransactions(Long.valueOf(accountNo));
			return new ResponseEntity<List<AccountTransactionOutput>>(outputList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<AccountTransactionOutput>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
