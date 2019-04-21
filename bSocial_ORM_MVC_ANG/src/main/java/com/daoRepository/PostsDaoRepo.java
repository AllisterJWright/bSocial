package com.daoRepository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.models.Posts;
import com.models.User;

@Repository("PostsDaoRepo")
@Transactional
@EnableTransactionManagement
public class PostsDaoRepo {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SessionFactory SF;
	
	public PostsDaoRepo() {
		
	}
	
	public int insert(Posts post) {
		SF.getCurrentSession().save(post);
		return 1;
	}
	
//	public int updatePost (Posts post, String username) {
//		SF.getCurrentSession().createQuery("update Posts set username= " + username());
//		return 0;
//	}
	
	public List<Posts> getPostByUser (String username) {
		 Query<Posts> query = SF.getCurrentSession().createNativeQuery("Select * From Posts Where username= :username")
				 .addEntity(Posts.class)
				 .setParameter("username", username);
		List<Posts> posts = query.list();
		return posts;
	}
	
	
	public List<Posts> getAllPost () {
		List<Posts> posts = SF.getCurrentSession().createQuery("from Posts", Posts.class).list();
		return posts;
	}

}
