package com.niit.backendcollaboration.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "blogcomments")

public class BlogCommentz {
	
	
	@Id
	@GeneratedValue
	private int id;

	private int blogId;
	private int userId;
	private String bcomments;
	private String username;
	private String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
	private String mail;
	                /// new methods 
	
	/*@ManyToOne
	private User commentedBy;
	*/
	
	
	/*private String Body;*/
	
	
	
	
/*	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBcomments() {
		return bcomments;
	}
	public void setBcomments(String bcomments) {
		this.bcomments = bcomments;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	
}
