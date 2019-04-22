package com.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Posts")
public class Posts {
	
	//fields
	@Id
	@Column(name= "Post_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Post_Id;
	
	@Column(name= "Title_Column")
	private String Title;
	
	@Column(name= "Image")
	private String image;
	
	@Column(name= "Caption")
	private String caption;
	
	@Column(name= "username")
	private String username;
	
	@Column(name = "likes")
	private int likes;
	
	@Column(name = "dislikes")
	private int dislikes;
	
//	@OneToMany(fetch= FetchType.EAGER, cascade= CascadeType.ALL)
//	@JoinColumn(name= "Comment_ID")
//	private List<Comments> comments;
//	
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name= "Ratings_ID")
//	private List<Ratings> ratings;	

	
	
	//getters and setters
	
	public int getPost_Id() {
		return Post_Id;
	}
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLikes()
	{
		return likes;
	}

	public void setLikes(int likes)
	{
		this.likes = likes;
	}

	public int getDislikes()
	{
		return dislikes;
	}

	public void setDislikes(int dislikes)
	{
		this.dislikes = dislikes;
	}

	//constructors
	public Posts() {
		super();
	}
//
//	public Posts(String title, String image, String caption) {
//		super();
//		this.Title = title;
//		this.image = image;
//		this.caption = caption;
//	}
	
	public Posts(String title, String image, String caption, String username) {
		super();
		this.Title = title;
		this.image = image;
		this.caption = caption;
		this.username = username;
		this.likes = 0;
		this.dislikes = 0;
	}

	public Posts(int post_Id, String title, String image, String caption, String username, int likes, int dislikes) {
		super();
		this.Post_Id = post_Id;
		this.Title = title;
		this.image = image;
		this.caption = caption;
		this.username = username;
		this.likes = likes;
		this.dislikes = dislikes;
	}

	@Override
	public String toString()
	{
		return "Posts [Post_Id=" + Post_Id + ", Title=" + Title + ", image=" + image + ", caption=" + caption
				+ ", username=" + username + ", likes=" + likes + ", dislikes=" + dislikes + "]";
	}
	
}
