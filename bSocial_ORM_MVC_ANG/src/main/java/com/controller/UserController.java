package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.models.User;
import com.services.UserService;

@Controller
@RestController("/bSocial")
public class UserController {

	@Autowired
	UserService US;
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value= "/register.rev", method=RequestMethod.POST)
	public int insertUser(@RequestBody User user) {
		System.out.println(user);
		User NewUser = new User(user.getUsername(),user.getPassword(),user.getEmail(),user.getDisplayName(),"https://i.imgur.com/eCcb3Uz.jpg");
		System.out.println(NewUser);
		US.register(NewUser);
		return 0;
	}
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value= "/Login.rev", method=RequestMethod.POST)
	public User loginUser (@RequestBody String username, String password) {
		User submittedUser = (new Gson()).fromJson(username, User.class);
		System.out.println(submittedUser);
		User updatedUser = US.Login(submittedUser.getUsername(), submittedUser.getPassword());
		System.out.println(updatedUser);
		return updatedUser;
	}
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value= "/searchUser.rev", method=RequestMethod.GET, params = {"username"})
	public User getUser(String username){
		User foundUser = US.findPerson(username);
		System.out.println(foundUser);
		return foundUser;
	}
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value= "/updateProfile.rev", method=RequestMethod.POST)
	public User UpdateUser (@RequestBody User user) {
		user.setDisplayImg("https://i.imgur.com/PL0l3PY.jpg");
		User updatedUser = US.update(user);
		System.out.println(updatedUser);
		return updatedUser;
	}
}
