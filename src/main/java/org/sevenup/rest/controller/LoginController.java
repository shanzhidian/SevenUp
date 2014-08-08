package org.sevenup.rest.controller;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.rest.domain.User;
import org.springframework.http.HttpEntity;
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
    public ResponseEntity<User> Login(@RequestBody User user ) {
    	System.out.println(user.getEmail());
    	System.out.println(user.getPassword());
    	user.setEmail("test@gmail.com");
    	user.setPassword("testpassword");
    	user.setUserName("testUserName");
       return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST, value = "login2/{userName}")
    public ResponseEntity<User> Login2(@PathVariable("userName") String userName) {
    	User user = new User();
    	user.setEmail("test@gmail.com");
    	user.setPassword("testpassword");
    	user.setUserName(userName);
       return new ResponseEntity<User>(user,HttpStatus.OK);
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
