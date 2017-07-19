package com.niit.backendcollaboration.DAO;

import java.util.List;

import com.niit.backendcollaboration.model.Friend;

public interface FriendDAO {
	
	public List<Friend> list();

	public List<Friend> list(int friendId);
	
	public Friend saveOrUpdate(Friend friend);

	public Friend getByFriendId(int id);
	
	public List<Friend> getByFriendName(String name);
	
	public List<Friend> getByFriendAccepted(String name);

	public void delete(int id);

}
