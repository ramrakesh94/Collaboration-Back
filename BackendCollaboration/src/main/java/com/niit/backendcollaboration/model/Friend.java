package com.niit.backendcollaboration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "friend")

public class Friend {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int userId;
	
	private int friendId;

	private String userName;

	private String friendName;
	
	private String Userstatus; // accepted / rejected
	
	private String isOnline;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getUserstatus() {
		return Userstatus;
	}

	public void setUserstatus(String userstatus) {
		Userstatus = userstatus;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}
	
	/*private Date lastSeen;*/
	

}
