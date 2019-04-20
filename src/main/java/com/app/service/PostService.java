package com.app.service;

import java.util.List;

import com.app.model.Post;
import com.app.repository.PostRepo;

public class PostService
{
	PostRepo postDao = new PostRepo();
	
	public  void insertPost(Post post)
	{
		postDao.insertPost(post);
	}
	
	public Post selectPostById(int id)
	{
		return postDao.selectPostById(id);
	}
	
	public List<Post> selectPostsByAuthor(String username)
	{
		return postDao.selectPostsByAuthor(username);
	}
	
	public List<Post> selectAllPosts()
	{
		return postDao.selectAllPosts();
	}
	
	public void updatePost(Post post)
	{
		postDao.updatePost(post);
	}
	
	public void deletePost(Post post)
	{
		postDao.deletePost(post);
	}
}