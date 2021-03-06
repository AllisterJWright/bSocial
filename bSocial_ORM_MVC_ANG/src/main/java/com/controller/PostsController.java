package com.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
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
import com.services.S3Service;

@RestController
public class PostsController
{

	@Autowired
	PostsService PS;

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/getAllPosts.rev", method = RequestMethod.GET)
	public @ResponseBody List<Posts> getAllPosts()
	{
		return PS.getAllPost();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getPostsByUser.rev", method = RequestMethod.GET)
	public @ResponseBody List<Posts> getPostsByUser(@RequestParam String username)
	{
		return PS.getUserPost(username);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/submitPost.rev", method = RequestMethod.POST)
	public int insertPost(@RequestBody String postJson)
	{
		System.out.println(postJson);
		Posts post = (new Gson()).fromJson(postJson, Posts.class);
		String imageFile = post.getImage();
		if (imageFile.contains("http"))
		{
			PS.insertPost(post);
			return 0;
		}
		else
		{
			String imageData = post.getImage().split(",")[1];
			System.out.println(imageData);
			try
			{
				byte[] imageBytes = Base64.getDecoder().decode(imageData.getBytes("UTF-8"));
				String s3Url = S3Service.submitImage(new ByteArrayInputStream(imageBytes));
//				String s3Url = S3Service.submitImage(imageFile);
				post.setImage(s3Url);
				System.out.println(post);
				PS.insertPost(post);
				return 0;
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return 1;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/updatePost.rev", method = RequestMethod.POST)
	public int updatePost(@RequestBody String postJson)
	{
		System.out.println(postJson);
		Posts post = (new Gson()).fromJson(postJson, Posts.class);
		String imageFile = post.getImage();
		if (imageFile.contains("http"))
		{
			PS.updatePost(post);
			return 0;
		}
		else
		{
			String imageData = post.getImage().split(",")[1];
			System.out.println(imageData);
			try
			{
				byte[] imageBytes = Base64.getDecoder().decode(imageData.getBytes("UTF-8"));
				String s3Url = S3Service.submitImage(new ByteArrayInputStream(imageBytes));
//				String s3Url = S3Service.submitImage(imageFile);
				post.setImage(s3Url);
				System.out.println(post);
				PS.insertPost(post);
				return 0;
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return 1;
	}
}
