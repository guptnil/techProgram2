package com.accounts.common.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.accounts.model.Account;
import com.accounts.service.AccountDataServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestAccountController {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private AccountDataServiceImpl service;

	
	@Test
	public void testGetAccounts() throws Exception {
		Date balanaceDate = Date.valueOf("2018-11-08");
		Account account = new Account(new Long(585309209), "SGSavings726", "Savings", balanaceDate, "SGD", 84327.51);
	 
	    when(service.getAccounts()).thenReturn(Arrays.asList(account));
	 
	    mockMvc.perform(get("/getAccounts"))
	    .andExpect(status().isOk())
	    .andExpect(content().json("[{\"accountNumber\":585309209,\"accountName\":\"SGSavings726\",\"accountType\":\"Savings\",\"balanceDate\":\"2018-11-08\",\"currency\":\"SGD\",\"availableBalance\":84327.51}]"));
	    
        verify(service, times(1)).getAccounts();
         
	}
	
	

}
