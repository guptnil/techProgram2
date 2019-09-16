package com.accounts.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.datamanager.AccountRepository;
import com.accounts.datamanager.TransactionRepository;
import com.accounts.model.Account;
import com.accounts.model.AccountTransaction;
import com.accounts.model.AccountTransactionOutput;

/**
 *
 * This class is business service implementation to handle any CRUD operations with accounts, transactions.
 *
 */
@Service
public class AccountDataServiceImpl implements AccountDataService{
	
	static Logger logger = Logger.getLogger(AccountDataServiceImpl.class.getName());
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public List<Account> getAccounts() {
		List<Account> accountList = new ArrayList<Account>();
		accountRepository.findAll().forEach(accountList::add);
		return accountList;
	}

	
	@Override
	public List<AccountTransactionOutput> getTransactions(Long accountNumber) {
		List<AccountTransaction> transactionList = transactionRepository.findTransactionsForAccount(accountNumber);
		List<AccountTransactionOutput> outputList = new ArrayList<AccountTransactionOutput>();
		if(transactionList !=null && !transactionList.isEmpty()) {
			for(AccountTransaction transaction : transactionList) {
				AccountTransactionOutput output = new AccountTransactionOutput();
				output.setTransactionNarrative(transaction.getTransactionNarrative());
				output.setTransactionType(transaction.getTransactionType());
				output.setValueDate(transaction.getValueDate());
				
				output.setAccountNumber(transaction.getAccount().getAccountNumber());
				output.setCurrency(transaction.getAccount().getCurrency());
				if(transaction.getTransactionType().equals("Credit")) {
					output.setCreditAmount(String.valueOf(transaction.getAmount()));
					output.setDebitAmount("");
				}else {
					output.setDebitAmount(String.valueOf(transaction.getAmount()));
					output.setDebitAmount("");
				}
				output.setAccountName(transaction.getAccount().getAccountType() + " Account");
				outputList.add(output);
			}
			
		}
		return outputList;
	
	}

	/**
	 *
	 * This is persisting some hardcoded accounts and transactions in database, in real life applications, we persist data from some source like
	 * UI or some data feed but given persistence is out of scope of this application, hence we are persisting some dummy hardcoded values.
	 *
	 */
	@Override
	public void saveAccounts() {
		Date balanceDate = Date.valueOf("2018-11-08");
		Account account1 = new Account(new Long(585309209), "SGSavings726", "Savings", balanceDate, "SGD", 84327.51);
		Account account2 = new Account(new Long(791066619), "AUSavings933", "Savings", balanceDate, "AUD", 88005.93);
		Account account3 = new Account(new Long(321143048), "AUCurrent433", "Current", balanceDate, "AUD", 38010.62);
		Account account4 = new Account(new Long(347786244), "SGCurrent166", "Current", balanceDate, "SGD", 50664.65);
		Account account5 = new Account(new Long(680168913), "AUCurrent374", "Current", balanceDate, "AUD", 41327.28);
		Account account6 = new Account(new Long(136056165), "AUSavings938", "Savings", balanceDate, "AUD", 48928.79);
		Account account7 = new Account(new Long(453963528), "SGSavings842", "Savings", balanceDate, "SGD", 72117.53);
		Account account8 = new Account(new Long(334666982), "AUSavings253", "Savings", balanceDate, "AUD", 20588.16);
		Account account9 = new Account(new Long(793949180), "AUCurrent754", "Current", balanceDate, "AUD", 88794.48);
		Account account10 = new Account(new Long(768759901), "SGCurrent294", "Current", balanceDate, "SGD", 5906.55);
		Account account11 = new Account(new Long(847257972), "AUCurrent591", "Current", balanceDate, "AUD", 92561.68);
		
		
		Date valueDate = Date.valueOf("2012-01-12");
		AccountTransaction t1 = new AccountTransaction(valueDate, 9540.98, "Credit", "",account1);
		AccountTransaction t2 = new AccountTransaction(valueDate, 7497.82, "Credit", "",account1);
		AccountTransaction t3 = new AccountTransaction(valueDate, 5564.79, "Credit", "",account1);
		AccountTransaction t4 = new AccountTransaction(valueDate, 8136.18, "Credit", "",account1);
		AccountTransaction t5 = new AccountTransaction(valueDate, 9442.46, "Credit", "",account1);
		AccountTransaction t6 = new AccountTransaction(valueDate, 7614.45, "Credit", "",account1);
		AccountTransaction t7 = new AccountTransaction(valueDate, 3311.55, "Credit", "",account1);
		AccountTransaction t8 = new AccountTransaction(valueDate, 9186.09, "Credit", "",account1);
		AccountTransaction t9 = new AccountTransaction(valueDate, 1905.86, "Credit", "",account1);
		AccountTransaction t10 = new AccountTransaction(valueDate, 197.78, "Credit", "",account1);
		AccountTransaction t11 = new AccountTransaction(valueDate, 8430.49, "Credit", "",account1);
		AccountTransaction t12 = new AccountTransaction(valueDate, 8.33, "Credit", "",account1);
		
		
		account1.getAccountTransactions().add(t1);
		account1.getAccountTransactions().add(t2);
		account1.getAccountTransactions().add(t3);
		account1.getAccountTransactions().add(t4);
		account1.getAccountTransactions().add(t5);
		account1.getAccountTransactions().add(t6);
		account1.getAccountTransactions().add(t7);
		account1.getAccountTransactions().add(t8);
		account1.getAccountTransactions().add(t9);
		account1.getAccountTransactions().add(t10);
		account1.getAccountTransactions().add(t11);
		account1.getAccountTransactions().add(t12);
		
		List<Account> accountsList = new ArrayList<Account>();
		accountsList.add(account1);
		accountsList.add(account2);
		accountsList.add(account3);
		accountsList.add(account4);
		accountsList.add(account5);
		accountsList.add(account6);
		accountsList.add(account7);
		accountsList.add(account8);
		accountsList.add(account9);
		accountsList.add(account10);
		accountsList.add(account11);
		
		accountRepository.saveAll(accountsList);
	}

}
