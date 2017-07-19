package com.niit.backendcollaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "blog23")
public class Blog {
	
    
	@Id
	@GeneratedValue
	private int blogId;
	
	private String blogtitle;
	
	/*@LOB*/
	private String blogDescription;
	
	private int userId;
	
	private String name;
	
	private String status;
	// new methods 
	/*@ManyToOne
	private User createdBy;*/
	
	private Date postedOn;
	
	

	
	

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	

	
	
	

	public String getBlogtitle() {
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}

	
	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
