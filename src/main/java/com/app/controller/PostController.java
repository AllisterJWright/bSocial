package com.app.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.Post;
import com.app.service.PostService;
import com.app.service.S3Service;

@Controller
public class PostController
{
	@Autowired
	PostService postService;
	
	// @CrossOrigin is used to handle the request from a different origin
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/submitPost", method=RequestMethod.POST)
	public @ResponseBody String submitPost(@PathVariable(value = "author") String authorName, 
											@PathVariable(value = "title") String title,
											@PathVariable(value = "description") String description,
											@PathVariable(value = "filestream") String filestream)
	{
		try
		{
			String s3URL = S3Service.submitImage(new ByteArrayInputStream(filestream.getBytes("UTF-8")));
			Post post = new Post(authorName, s3URL, description, title);
			postService.insertPost(post);
			
			return s3URL;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/getPosts", method=RequestMethod.POST)
	public @ResponseBody List<Post> getPostFeed(@PathVariable(name = "username") String username)
	{
		if (username == "")
			return postService.selectAllPosts();
		else
			return postService.selectPostsByAuthor(username);
	}

}