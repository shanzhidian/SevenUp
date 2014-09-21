package org.sevenup.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.rest.domain.Account;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		for (int i = 0; i < 10; i++) {
			Account tempAccount = new Account();
			tempAccount.setAccountName("Nonumber00" + i);
			tempAccount.setEmail("nonumber" + i + "@gmail.com");
			tempAccount.setPassword("nonumber1989");
			accounts.add(tempAccount);
		}
		return accounts;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Account> viewAccount(@PathVariable String id) {
		// return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		Account tempAccount = new Account();
		tempAccount.setAccountName("Nonumber00");
		tempAccount.setEmail("nonumber" + "@gmail.com");
		tempAccount.setPassword("nonumber1989");
		return new ResponseEntity<Account>(tempAccount, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Account> createAcount(@RequestBody Account account,
			UriComponentsBuilder builder) {
		System.out.println(account.getEmail());
		UUID idKey = UUID.randomUUID();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/sevenUp/accounts/{id}")
				.buildAndExpand(idKey.toString()).toUri());
		return new ResponseEntity<Account>(account, headers, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "signIn")
	@ResponseBody
	public boolean createUser(@RequestBody Account account) {
		System.out.println("userName: " + account.getAccountName());
		System.out.println("password: " + account.getPassword());
		return true;
	}

	@RequestMapping(method = RequestMethod.POST, value = "signUp")
	public ResponseEntity<Account> signUp(@RequestBody Account account) {
		System.out.println("userName: " + account.getAccountName());
		System.out.println("password: " + account.getPassword());
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
}
