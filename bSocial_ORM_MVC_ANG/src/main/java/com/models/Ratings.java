package com.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name= "Ratings")
public class Ratings {
	
	@Id
	@Column(name= "ratings_ID")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int ratingsID;
	
	@Column(name= "value")
	private String value;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "Post_ID")
	Posts post;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "username")
	User user;
	
	//Getters and Setters
	
	
	public void setPost(Posts post) {
		this.post = post;
	}
	public int getRatingsID() {
		return ratingsID;
	}
	public String getValue() {
		return value;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//Constructors
	public Ratings() {
		super();
	}
	
	public Ratings(Posts post, User user) {
		super();
		this.post = post;
		this.user = user;
	}
	
	public Ratings(int ratingsID, String value, Posts post, User user) {
		super();
		this.ratingsID = ratingsID;
		this.value = value;
		this.post = post;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Ratings [ratingsID=" + ratingsID + ", value=" + value + ", post=" + post + ", user=" + user + "]";
	}

	
}
