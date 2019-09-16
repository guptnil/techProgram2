package com.accounts.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.accounts.service.AccountDataService;

@SpringBootApplication
@EnableJpaRepositories("com.accounts")
@EnableAutoConfiguration
@EntityScan("com.accounts.model")
@ComponentScan("com.accounts")
public class MainRunner{

	/**
	 * Starting point of Springboot application.
	 * It calls the underlying business service to save pre defined account information(Given account creation s out of scope of this project , so we are populating some hard
	 * coded accounts in the database)
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(MainRunner.class, args);
		AccountDataService service = applicationContext.getBean(AccountDataService.class);
        service.saveAccounts();
		
	}
	
	

}
