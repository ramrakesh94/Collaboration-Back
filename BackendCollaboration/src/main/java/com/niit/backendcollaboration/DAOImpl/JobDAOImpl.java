package com.niit.backendcollaboration.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendcollaboration.DAO.JobDAO;
import com.niit.backendcollaboration.model.Blog;
import com.niit.backendcollaboration.model.Job;
@Transactional
@Repository
public class JobDAOImpl implements JobDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public List<Job> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Job").list();
	}

	public void saveOrUpdate(Job job) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		
	}

	public Job getByJobId(int id) {
		// TODO Auto-generated method stub
		Job jobListByID = (Job) sessionFactory.getCurrentSession().get(Job.class, id);

		return jobListByID;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Job jobDelete = new Job();
		jobDelete.setId(id);
		sessionFactory.getCurrentSession().delete(jobDelete);
	}
	
	

}
