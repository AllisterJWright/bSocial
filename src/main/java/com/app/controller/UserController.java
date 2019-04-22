package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.User;
import com.app.service.UserService;

@Controller
public class UserController
{
	@Autowired
	UserService userService;
	
	// @CrossOrigin is used to handle the request from a different origin
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/register.app", method=RequestMethod.POST)
	public @ResponseBody String registerUser(@PathVariable(value = "name") String name, 
											@PathVariable(value = "email") String email,
											@PathVariable(value = "username") String username,
											@PathVariable(value = "password") String password)
	{
		String defaultProfileImage = "default-profile-image";
		User user = new User(username, password, email, name, defaultProfileImage);
		userService.insertUser(user);
		return "login";
	}

}