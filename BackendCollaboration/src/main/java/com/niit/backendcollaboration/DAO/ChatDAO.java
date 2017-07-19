package com.niit.backendcollaboration.DAO;

import java.util.List;

import com.niit.backendcollaboration.model.Chat;

public interface ChatDAO {
	
    public List<Chat> list();
	
	public void saveOrUpdate(Chat chat);

	public Chat getByFriendId(int id);
	
	public void delete(int id);

}
