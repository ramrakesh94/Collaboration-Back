package com.niit.backendcollaboration.DAO;

import java.util.List;

import com.niit.backendcollaboration.model.Blog;
import com.niit.backendcollaboration.model.BlogCommentz;

public interface BlogDAO {

	public List<Blog> list();
	
	public List<Blog> getApprovedList();
	
	public List<Blog> getNotApprovedList();

	public Blog get(int id);
	

	
	public Blog get_title(String title);

	
	
	public void saveOrUpdate(Blog blog);

	public void delete(int id);

	public void addComment(BlogCommentz blogcomment);
	
	
}
