package com.daoRepository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.models.Comments;
import com.models.Posts;
import com.models.User;

@Repository("CommentsDaoRepo")
@Transactional
@EnableTransactionManagement
public class CommentsDaoRepo {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SessionFactory SF;
	
	public CommentsDaoRepo() {}
	
	public int insert(Comments comment) { //not mapped to post or user just yet
		SF.getCurrentSession().save(comment);
		return 0;
	}
	
	public List<Comments> selectCommentsByPost(Posts post) {
		List<Comments> comments = SF.getCurrentSession().createQuery("from Comments where Post_ID= " + post.getPost_Id(), Comments.class).list();
		return comments;
	}
	
	public int updateCommentWithInfo(User user, Posts post, Comments comment) {
		SF.getCurrentSession().createQuery("update Comments set username =" + user.getUsername() + ",Post_ID= " + post.getPost_Id() + "where Comment_ID= " + comment.getCommentId());
		return 0;
	}
	
	
}
