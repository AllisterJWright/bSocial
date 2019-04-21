package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.email.EmailHandler;
import com.google.gson.Gson;
import com.models.User;
import com.services.UserService;

@Controller
@RestController("/bSocial")
public class UserController
{

	@Autowired
	UserService US;

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/register.rev", method = RequestMethod.POST)
	public int insertUser(@RequestBody User user)
	{
		System.out.println(user);
		User NewUser = new User(user.getUsername(), user.getPassword(), user.getEmail(), user.getDisplayName(),
				"https://i.imgur.com/eCcb3Uz.jpg");
		System.out.println(NewUser);
		US.register(NewUser);
		return 0;
	}

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/Login.rev", method = RequestMethod.POST)
	public User loginUser(@RequestBody String jsonString)
	{
		User submittedUser = (new Gson()).fromJson(jsonString, User.class);
		System.out.println(submittedUser);
		User updatedUser = US.Login(submittedUser.getUsername(), submittedUser.getPassword());
		System.out.println(updatedUser);
		return updatedUser;
	}

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/searchUser.rev", method = RequestMethod.GET, params =
		{ "username" })
	public User getUser(String username)
	{
		User foundUser = US.findPerson(username);
		System.out.println(foundUser);
		return foundUser;
	}

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/getAllUsers.rev", method = RequestMethod.GET)
	public List<User> getAllUsers()
	{
		List<User> uList = US.selectAllUsers();
		uList.forEach(System.out::println);
		return uList;
	}

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/updateProfile.rev", method = RequestMethod.POST)
	public User UpdateUser(@RequestBody String jsonString)
	{
		User user = (new Gson()).fromJson(jsonString, User.class);
		user.setDisplayImg("https://i.imgur.com/PL0l3PY.jpg");
		User updatedUser = US.update(user);
		System.out.println(updatedUser);
		return updatedUser;
	}

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/forgotPassword.rev", method = RequestMethod.POST)
	public void sendPasswordEmail(@RequestParam String email)
	{
		String newPassword = new Integer(100000 + new Random().nextInt(90000)).toString();
		User userToReset = US.selectUserByEmail(email);
		if (userToReset != null)
		{
			userToReset.setPassword(newPassword);
			US.update(userToReset);
			EmailHandler.setReceiver(email);
			try
			{
				EmailHandler.sendEmail(newPassword);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
