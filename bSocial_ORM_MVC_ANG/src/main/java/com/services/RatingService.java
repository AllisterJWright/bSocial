package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.daoRepository.RatingsDaoRepo;
import com.daoRepository.UserDaoRepo;
import com.models.Posts;
import com.models.Ratings;
import com.models.User;

@Service
public class RatingService {

	@Autowired
	RatingsDaoRepo RDR;
	
	public int AddRating(User user, Posts post, Ratings rating) {
		RDR.insert(rating);
		RDR.updateOnInsert(user, post);
		return 0;
	}
	
	public int DeleteRating(Ratings rating) {
		RDR.delete(rating);
		return 0;
	}
}
