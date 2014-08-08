package org.sevenup.rest.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.rest.domain.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {

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
