package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.daoRepository.PostsDaoRepo;
import com.daoRepository.RatingsDaoRepo;
import com.daoRepository.UserDaoRepo;
import com.models.Posts;
import com.models.User;

@Service
public class PostsService {

	@Autowired
	PostsDaoRepo PDR;
	
	public List<Posts> getUserPost(String username){
		return PDR.getPostByUser(username);
	}
	
	public void insertPost(Posts post) {
		PDR.insert(post);
	}
	
	public List<Posts> getAllPost(){
		return PDR.getAllPost();
	}
	
	public void updatePost(Posts post)
	{
		PDR.updatePost(post);
	}
}
