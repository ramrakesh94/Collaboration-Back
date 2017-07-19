package com.niit.backendcollaboration.DAO;

import java.util.List;

import com.niit.backendcollaboration.model.User;

public interface UserDAO {
	
	public List<User> list();

	public void saveOrUpdate(User user);

	public User getById(int id);
	
	public User getByName(String name);
	
	public User getByEmail(String email);
	
	public void delete(int id);

	public User login(User user);
	
	List<String> getOnlineUsers();

}
