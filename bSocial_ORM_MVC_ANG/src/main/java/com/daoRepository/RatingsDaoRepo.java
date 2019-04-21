package com.daoRepository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.models.Posts;
import com.models.Ratings;
import com.models.User;

@Repository ("RatingsDaoRepo")
@Transactional
@EnableTransactionManagement
public class RatingsDaoRepo {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SessionFactory SF;
	
	public RatingsDaoRepo() {}
	
	public int insert(Ratings Rating) {
		SF.getCurrentSession().save(Rating);
		return 0;
	}
	
	public int updateOnInsert(User user, Posts post) {
		SF.getCurrentSession().createQuery("update Ratings set username= " + user.getUsername() + "set Post_ID= " + post.getPost_Id());
		return 0;
	}
	
	public int delete(Ratings rating) {
		SF.getCurrentSession().delete(rating);
		return 0;
	}

}
