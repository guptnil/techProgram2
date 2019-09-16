package com.accounts.common.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accounts.model.Account;
import com.accounts.model.AccountTransactionOutput;
import com.accounts.service.AccountDataService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestAccountDataService {
	
	@Autowired
	AccountDataService service;
	
	@Before
	public void setup() {
		service.saveAccounts();
	}
	
	@Test
	public void testAccountsRetrieval() {
		List<Account> accountList = service.getAccounts();
	    assertEquals(11, accountList.size());
	    
	}
	
	@Test
	public void testTransactionsRetrieval() {
		List<AccountTransactionOutput> transactionList = service.getTransactions(new Long(585309209));
	    assertEquals(12, transactionList.size());
	    
	}
	
	

}
