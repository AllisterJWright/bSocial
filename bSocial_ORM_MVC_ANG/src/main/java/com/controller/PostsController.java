package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.models.Posts;
import com.services.PostsService;
@RestController
public class PostsController {
	
	@Autowired
	PostsService PS;
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value="/getAllPosts.rev" ,  method=RequestMethod.GET)
	public @ResponseBody List<Posts> getAllPosts (){
		return PS.getAllPost();
	} 
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/getPostsByUser.rev" , method=RequestMethod.GET)
	public @ResponseBody List<Posts> getPostsByUser (@RequestParam String username){
		return PS.getUserPost(username);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/submitPost.rev" , method=RequestMethod.POST)
	public int insertPost (@RequestBody String postJson) 
	{
		System.out.println(postJson);
		Posts newPost = (new Gson()).fromJson(postJson, Posts.class);
		System.out.println(newPost);
		PS.insertPost(newPost);
		return 0;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/updatePost.rev" , method=RequestMethod.POST)
	public int updatePost(@RequestBody String postJson)
	{
		System.out.println(postJson);
		Posts updatedPost = (new Gson()).fromJson(postJson, Posts.class);
		System.out.println(updatedPost);
		PS.updatePost(updatedPost);
		return 0;
	}
}
