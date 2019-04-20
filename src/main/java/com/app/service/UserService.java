package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepo;

@Service
public class UserService
{
	UserRepo userDao = new UserRepo();
	
	public void insertUser(User user)
	{
		userDao.insertUser(user);
	}
	
	public User selectUserByUsername(String username)
	{
		return userDao.selectUserByUsername(username);
	}
	
	public List<User> selectAllUsers()
	{
		return userDao.selectAllUsers();
	}
	
	public void updateUser(User user)
	{
		userDao.updateUser(user);
	}
	
	public void deleteUser(User user)
	{
		userDao.deleteUser(user);
	}

}