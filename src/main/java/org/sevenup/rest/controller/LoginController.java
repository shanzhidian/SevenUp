package org.sevenup.rest.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.rest.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {
    @RequestMapping(method = RequestMethod.POST, value = "login")
    public ResponseEntity<User> deleteAccount(@RequestBody User user ) {
    	System.out.println(user.getEmail());
    	System.out.println(user.getPassword());
    	user.setEmail("test@gmail.com");
    	user.setPassword("testpassword");
    	user.setUserName("testUserName");
       return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
