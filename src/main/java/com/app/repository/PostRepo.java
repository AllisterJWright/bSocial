package com.app.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.Post;

public class PostRepo
{
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SessionFactory sesFact;
	
	public PostRepo() {}
	
	public void insertPost(Post post)
	{
		sesFact.getCurrentSession().save(post);
	}
	
	public Post selectPostById(int id)
	{
		return sesFact.getCurrentSession().get(Post.class, id);
	}
	
	public List<Post> selectPostsByAuthor(String username)
	{
		return sesFact.getCurrentSession().createQuery("from Post where author_name = :name")
											.setParameter("name", username)
											.getResultList();
	}
	
	public List<Post> selectAllPosts()
	{
		return sesFact.getCurrentSession().createQuery("from Post").list();
	}
	
	public void updatePost(Post post)
	{
		sesFact.getCurrentSession().update(post);
	}
	
	public void deletePost(Post post)
	{
		sesFact.getCurrentSession().delete(post);
	}
}
