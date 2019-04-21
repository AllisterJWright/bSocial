package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

import com.models.Posts;
import com.models.User;
import com.services.PostsService;

@Controller
public class PostsController {
	
	@Autowired
	PostsService PS;
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value="/autoAddPosts.rev" ,  method=RequestMethod.POST)
	public List<Posts> getAllPosts (){
		return PS.getAllPost();
	} 
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/autoAddUserPosts.rev" , method=RequestMethod.POST)
	public List<Posts> getUserPost (@RequestBody String username){
		return PS.getUserPost(username);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/addUserPosts.rev" , method=RequestMethod.POST)
	public int insertPost (@RequestBody Posts post) {
		
		Posts Newpost = new Posts(post.getTitle(),post.getImage(),post.getCaption());
		System.out.println(post);
		PS.insertPost(Newpost);
		System.out.println(Newpost);
		return 0;
	}
	

}
