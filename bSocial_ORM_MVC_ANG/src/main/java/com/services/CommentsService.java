package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.daoRepository.CommentsDaoRepo;
import com.daoRepository.RatingsDaoRepo;
import com.models.Comments;
import com.models.Posts;
import com.models.User;

@Service
public class CommentsService {
	
	@Autowired
	CommentsDaoRepo CDR;
	
	
	public List<Comments> getAllComments(Posts post) {
		return CDR.selectCommentsByPost(post);
	}
	
	public int AddComment(User user, Posts post, Comments comment) {
		CDR.insert(comment);
		CDR.updateCommentWithInfo(user, post, comment);
		return 0;
	}
	
	

}
