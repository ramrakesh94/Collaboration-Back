package com.niit.backendcollaboration.DAO;

import java.util.List;

import com.niit.backendcollaboration.model.BlogCommentz;

public interface BlogCommentsDAO {
	
    public List<BlogCommentz> list();
	
	public List<BlogCommentz> getBlogComments(int blogId);
	
	public BlogCommentz getBlogComment(int blogCommentId);
	
	public BlogCommentz saveOrUpdate(BlogCommentz bcomment);
		
	public void delete(int id);
	


}
