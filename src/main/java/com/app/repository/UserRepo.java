package com.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.User;

@Repository("userRepo")
@Transactional
public class UserRepo {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SessionFactory sesFact;
	
	public UserRepo() {
	}
	
	public void insertUser(User user) {
		sesFact.getCurrentSession().save(user);
	}
	
	public User selectUserByUsername(String username) {
		return sesFact.getCurrentSession().get(User.class, username);
	}
	
	public List<User> selectAllUsers() {
		List<User> userList = sesFact.getCurrentSession().createQuery("from User", User.class).list();
		return userList;
	}

	public void updateUser(User user) {
		sesFact.getCurrentSession().update(user);
	}
	
	public void deleteUser(User user) {
		sesFact.getCurrentSession().remove(user);
	}
}
