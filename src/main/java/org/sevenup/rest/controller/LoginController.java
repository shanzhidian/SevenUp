package org.sevenup.rest.controller;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.rest.domain.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {
    @RequestMapping(method = RequestMethod.POST, value = "login")
    public ResponseEntity<Account> Login(@RequestBody Account account ) {
    	System.out.println(account.getEmail());
    	System.out.println(account.getPassword());
    	account.setEmail("test@gmail.com");
    	account.setPassword("testpassword");
    	account.setAccountName("testUserName");
       return new ResponseEntity<Account>(account,HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST, value = "login2/{userName}")
    public ResponseEntity<Account> Login2(@PathVariable("userName") String userName) {
    	Account account = new Account();
    	account.setEmail("test@gmail.com");
    	account.setPassword("testpassword");
    	account.setAccountName(userName);
       return new ResponseEntity<Account>(account,HttpStatus.OK);
    }
    
    @RequestMapping(value="/cities", method=RequestMethod.POST)
    @ResponseBody
    public String[] cities(HttpServletResponse response){
        String[] cities={"New York","London","Amsterdam","Paris","Milan","Madrid","Sydney","Tokyo","Singapore","Yangon","Rio","Vegas"};
 
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
 
                return cities;
    }
}
