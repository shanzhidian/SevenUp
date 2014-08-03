package org.sevenup.rest.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.rest.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

	@RequestMapping(method = RequestMethod.POST,value = "signUp")
	@ResponseBody
	public boolean createUser(@RequestBody User user) {
		System.out.println(user.getUserName()+"--"+user.getPassword()+"--"+user.getEmail());
		return true;
	}
}
