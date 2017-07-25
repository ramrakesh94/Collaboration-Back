package com.niit.backendcollaboration.DAO;

import java.util.List;

import com.niit.backendcollaboration.model.Friend;

public interface FriendDAO {
	
	public List<Friend> list();

	public List<Friend> getByUser(int userId);

	public List<Friend> getByName(String userName);

	public List<Friend> getByFriendName(String userName);

	public void save(Friend friend);

	public Friend saveOrUpdate(Friend friend);

	public List<Friend> getByFriendAccepted(String name);
	
	public List<Friend> getByFriendAccepted1(String name);

	public List<Friend> list(int friendId);
	

}
