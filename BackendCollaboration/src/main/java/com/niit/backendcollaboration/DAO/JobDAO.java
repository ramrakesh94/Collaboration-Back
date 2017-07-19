package com.niit.backendcollaboration.DAO;

import java.util.List;

import com.niit.backendcollaboration.model.Job;

public interface JobDAO {
	
	
	public List<Job> list();

	public void saveOrUpdate(Job job);

	public Job getByJobId(int id);

	public void delete(int id);


}
