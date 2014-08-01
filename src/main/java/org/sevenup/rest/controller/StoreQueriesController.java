package org.sevenup.rest.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.rest.domain.Account;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author steven
 * for shops query
 */

@Controller
@Produces(MediaType.APPLICATION_JSON)
public class StoreQueriesController {
    @RequestMapping(method = RequestMethod.POST, value = "tiger")
    public ResponseEntity<Account> deleteAccount(@RequestBody Account account ) {
    	System.out.println(account.getAccountName());
    	System.out.println(account.getEmail());
    	System.out.println(account.getPassword());
//    	Account account = new Account();
//    	System.out.println(account.getPassword()+"---"+account.getEmail());
       return new ResponseEntity<Account>(HttpStatus.BAD_GATEWAY);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "tiger/{id}")
    public ResponseEntity<Account> test(@PathVariable String id ) {
    	System.out.println("myid"+"----"+id);
    	Account account = new Account();
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

}
