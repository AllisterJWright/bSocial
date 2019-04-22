package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "User_Posts")
public class Post
{
	@Id
	@Column (name = "post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int postId;
	
	@Column (name = "author_name", nullable = false)
	String username;
	
	@Column (name = "image_url", nullable = false)
	String imageURL;
	
	@Column (name = "description")
	String description;
	
	@Column (name = "title", nullable = false)
	String title;
	
//	@Column (name = "created_at", nullable=false)
//	@CreationTimestamp
//	String timestampOrig;
//	
//	@Column (name = "last_edited")
//	@UpdateTimestamp
//	String timestampEdit;

	public Post()
	{	}

	public Post(int postId, String username, String imageURL, String description, String title, String timestampOrig,
			String timestampEdit)
	{
		super();
		this.postId = postId;
		this.username = username;
		this.imageURL = imageURL;
		this.description = description;
		this.title = title;
//		this.timestampOrig = timestampOrig;
//		this.timestampEdit = timestampEdit;
	}

	public Post(String username, String imageURL, String description, String title)
	{
		super();
		this.username = username;
		this.imageURL = imageURL;
		this.description = description;
		this.title = title;
	}

	public int getPostId()
	{
		return postId;
	}

	public void setPostId(int postId)
	{
		this.postId = postId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getImageURL()
	{
		return imageURL;
	}

	public void setImageURL(String imageURL)
	{
		this.imageURL = imageURL;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

//	public String getTimestampOrig()
//	{
//		return timestampOrig;
//	}
//
//	public String getTimestampEdit()
//	{
//		return timestampEdit;
//	}

	@Override
	public String toString()
	{
		return "Post [postId=" + postId + ", username=" + username + ", imageURL=" + imageURL + ", description="
				+ description + ", title=" + title + "]";
//				, timestampOrig=" + timestampOrig + ", timestampEdit="
//				+ timestampEdit + "]";
	}
	
}
