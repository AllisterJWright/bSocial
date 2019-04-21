package com.models;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Comments")
public class Comments {
	
	@Id
	@Column(name= "Comment_ID")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int CommentId;
	
	@Column(name= "Post_ID")
	private int postID;
	
	@Column(name= "username")
	private String username;
	
	@Column(name= "Message")
	private String comment;
	
	
	//Getters
	

	public int getCommentId() {
		return CommentId;
	}

	public String getUser() {
		return username;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	//constructors
	public Comments() {
		super();
	}	
	
	

	public Comments(int postID, String user, String comment) {
		super();
		this.postID = postID;
		this.username = user;
		this.comment = comment;
	}

	public Comments(int commentId, int postID, String user, String comment) {
		super();
		CommentId = commentId;
		this.postID = postID;
		this.username = user;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comments [CommentId=" + CommentId + ", postID=" + postID + ", username=" + username + ", comment="
				+ comment + "]";
	}
	
}
