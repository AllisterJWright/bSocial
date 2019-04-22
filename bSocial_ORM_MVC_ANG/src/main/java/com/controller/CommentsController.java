package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.models.Comments;
import com.models.Posts;
import com.models.User;
import com.services.CommentsService;

@Controller
public class CommentsController {
	
	@Autowired
	CommentsService CS;
	
	//HAVE TO CHANGE TO YOUR PORT NUMBER
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="{post, comment, user}/addComment.rev")
	public @ResponseBody int AddComment(@PathVariable("post") Posts post, @PathVariable(value= "comment") Comments comment, @PathVariable("user") User user){
		CS.AddComment(user, post, comment);
		CS.getAllComments(post);
		return 0;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="{post}/autoAddComments.rev")
	public @ResponseBody List<Comments> getAllComments(@PathVariable(value= "post") Posts post){
		return CS.getAllComments(post);
	}
}
