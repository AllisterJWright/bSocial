package com.daoRepository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.models.User;


@Repository("UserDaoRepo")
@Transactional
@EnableTransactionManagement
public class UserDaoRepo {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SessionFactory SF;
	
	public UserDaoRepo(){	}
	
	public int insert (User user) {
		SF.getCurrentSession().save(user);
		return 0;
	}
	
	public int updateUser (User user) {
		Query query = SF.getCurrentSession().createQuery("UPDATE Users set displayName= :newName, "
										+ "password= :newPw, email = :newEmail, "
										+ "display_image= :newPic WHERE username= :targetUser")
								.setParameter("newName", user.getDisplayName())
								.setParameter("newPw", user.getPassword())
								.setParameter("newEmail", user.getEmail())
								.setParameter("newPic", user.getDisplayImg())
								.setParameter("targetUser", user.getUsername());
		return query.executeUpdate();
	}
	
	public User selectUser (String username) {
		return SF.getCurrentSession().get(User.class, username);
	}
	
	// Return user from login credentials
	public User selectUser(String username, String password) {
		 Query<User> query = SF.getCurrentSession().createQuery("From User Where username= :username AND Password= :password", User.class)
//				 									.addEntity(User.class)
				 									.setParameter("username", username)
				 									.setParameter("password", password);
		 
		 List<User> users =  query.list();
		 
		User u = null;
		for (User user : users)
			u = user;
//		Iterator<User> obsIterator = users.iterator();
//		while(obsIterator.hasNext()) {
//			User ob = obsIterator.next();
//			return ob;
//		}

		return u;
		
	}
	
//	public int selectAllUsers () {
//		List<User> users = SF.getCurrentSession().createQuery("from Users", User.class).list();
//		return 1;
//	}

}
