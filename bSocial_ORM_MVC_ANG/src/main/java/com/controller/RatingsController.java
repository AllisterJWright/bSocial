package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

//import com.models.Comments;
import com.models.Posts;
import com.models.Ratings;
import com.models.User;
import com.services.RatingService;

@Controller
public class RatingsController {
	
	@Autowired
	RatingService RS;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="{post, user, rating}/addRating.rev")
	public @ResponseBody int AddRating(@PathVariable(value= "post") Posts post, @PathVariable(value= "rating") Ratings rating, @PathVariable(value= "user") User user){
		RS.AddRating(user, post, rating);
		return 0;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="{rating}/deleteRating.rev")
	public @ResponseBody int DeleteRating(@PathVariable(value= "rating") Ratings rating){
		RS.DeleteRating(rating);
		return 0;
	}
	
}
