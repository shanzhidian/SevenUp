package org.sevenup.rest.controller;

import org.sevenup.util.ViewFormatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * 
 * @author steven
 * 
 */
@Controller
public class UserController {

	@RequestMapping(value = "/7Up/user/users/{format}", method = RequestMethod.GET)
	public ModelAndView searchUser(@PathVariable("format") String format) {
		View theView = ViewFormatUtil.getView(format);
		return new ModelAndView(theView, "response", new Object());
	}

	@RequestMapping(value = "/7Up/user/users/{format}", method = RequestMethod.PUT)
	public ModelAndView updateUser(@PathVariable("format") String format) {
		View theView = ViewFormatUtil.getView(format);
		return new ModelAndView(theView, "response", new Object());
	}

	@RequestMapping(value = "/7Up/user/users/{format}", method = RequestMethod.DELETE)
	public ModelAndView deleteUser(@PathVariable("format") String format) {
		View theView = ViewFormatUtil.getView(format);
		return new ModelAndView(theView, "response", new Object());
	}

	@RequestMapping(value = "/7Up/user/users/{format}", method = RequestMethod.POST)
	public ModelAndView createUser(@PathVariable("format") String format) {
		View theView = ViewFormatUtil.getView(format);
		return new ModelAndView(theView, "response", new Object());
	}
}
