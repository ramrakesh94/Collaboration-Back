package com.niit.backendcollaboration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "forum4567")

public class Forum {
	
	@Id
	@GeneratedValue
     private int forumId;
	
	private String forumTitle;
	
/*	@LOB*/
	private String forumbodycontent;
	private int userid;// should it be userId 
	private String name;
	private String status;
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getForumTitle() {
		return forumTitle;
	}
	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}
	public String getForumbodycontent() {
		return forumbodycontent;
	}
	public void setForumbodycontent(String forumbodycontent) {
		this.forumbodycontent = forumbodycontent;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
