package com.accounts.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * This is a wrapper object to contain information required for viewing transactions.
 *
 */
public class AccountTransactionOutput implements Serializable{
	
	private static final long serialVersionUID = 4000379720424807738L;

	private String currency;
	
	private Long accountNumber;
	
	private String accountName;
	
	private String creditAmount;
	
	private String debitAmount;
	
	String transactionNarrative;
	
	Date valueDate;
	
	String transactionType;
	
	public AccountTransactionOutput() {
		super();
	}

	public AccountTransactionOutput(String currency, Long accountNumber, String accountName, String creditAmount,
			String debitAmount, String transactionNarrative, Date valueDate, String transactionType) {
		super();
		this.currency = currency;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.transactionNarrative = transactionNarrative;
		this.valueDate = valueDate;
		this.transactionType = transactionType;
	}

	
	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(String debitAmount) {
		this.debitAmount = debitAmount;
	}

	

}
