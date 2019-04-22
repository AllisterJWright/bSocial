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
	
	public void insert(Posts post) {
		SF.getCurrentSession().save(post);
	}
	
	public List<Posts> getPostByUser (String username) {
		 Query<Posts> query = SF.getCurrentSession().createQuery("From Posts Where username= :username", Posts.class)
				 .setParameter("username", username);
		List<Posts> posts = query.list();
		return posts;
	}
	
	
	public List<Posts> getAllPost () {
		List<Posts> posts = SF.getCurrentSession().createQuery("from Posts", Posts.class).list();
		return posts;
	}
	
	public void updatePost(Posts post)
	{
		Query query = SF.getCurrentSession().createQuery("UPDATE Posts set Title= :newTitle, "
													+ "image= :newImage, caption= :newCaption, "
													+ "likes= :newLikes, dislikes= :newDislikes"
													+ " WHERE Post_ID= :targetID")
											.setParameter("newTitle", post.getTitle())
											.setParameter("newImage", post.getImage())
											.setParameter("newCaption", post.getCaption())
											.setParameter("newLikes", post.getLikes())
											.setParameter("newDislikes", post.getDislikes())
											.setParameter("targetID", post.getPost_Id());
		query.executeUpdate();
	}

}
