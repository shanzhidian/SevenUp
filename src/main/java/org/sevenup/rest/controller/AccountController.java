package org.sevenup.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.rest.domain.Account;
import org.sevenup.rest.domain.Accounts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 
 * @author steven
 * 
 */
@Controller
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {

	@RequestMapping(value="good",method=RequestMethod.POST)
	@ResponseBody
	public List<Account> getList(){
		List<Account> accounts = new ArrayList<Account>();
		for(int i=0;i<5;i++){
			Account account = new Account();
			account.setAccountName("name"+i);
			account.setEmail("email"+i);
			account.setPassword("password"+i);
			accounts.add(account);
		}
		return accounts;
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ResponseEntity<Accounts> login() {
		List<Account> accounts = new ArrayList<Account>();
		for(int i =0;i<5;i++){
			Account account = new Account();
			account.setEmail("nonumber1989@gmail.com");
			account.setPassword("nonumber1989");	
			account.setAccountName("testseven");
			accounts.add(account);
		}
		Accounts myAccounts = new Accounts();
		myAccounts.setAccounts(accounts);
	    return new ResponseEntity<Accounts>(myAccounts, HttpStatus.OK);
	}
	
	@RequestMapping(value="seven12/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Account> seven(@PathVariable String id) {
		System.out.println(id+"9999");
		Account account = new Account();
		account.setEmail("nonumber1989@gmail.com");
		account.setPassword("nonumber1989");
		account.setAccountName(id);
	    return new ResponseEntity<Account>(account,HttpStatus.OK);
	}
    
}
