package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoRepository.UserDaoRepo;
import com.models.User;

@Service
public class UserService {

	@Autowired
	UserDaoRepo UDR;

	public User findPerson (String username) {
		return UDR.selectUser(username);
	}
	
	public List<User> selectAllUsers()
	{
		return UDR.selectAllUsers();
	}
	
	public User selectUserByEmail(String email)
	{
		return UDR.selectUserByEmail(email);
	}
	
	public int register (User user) {
		UDR.insert(user);
		return 0;
	}
	
	public User Login (String username, String password) {
		System.out.println(username + ", " + password);
		User LoginUser = UDR.selectUser(username, password);
		System.out.println(LoginUser);
		return LoginUser;
	}
	
	public User update (User user) {
		UDR.updateUser(user);
		return UDR.selectUser(user.getUsername());
	}
	
}
