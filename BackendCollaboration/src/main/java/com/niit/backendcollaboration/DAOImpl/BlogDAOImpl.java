package com.niit.backendcollaboration.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendcollaboration.DAO.BlogDAO;
import com.niit.backendcollaboration.model.Blog;
import com.niit.backendcollaboration.model.BlogCommentz;


@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO  {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Blog> list() {
		@SuppressWarnings("unchecked")
		List<Blog> blogList = sessionFactory.getCurrentSession().createQuery("from Blog").list();
		return blogList;
	}

	public List<Blog> getApprovedList() {
		
		String hql = "from Blog where status = " + "'A'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();
		
		return list;
	}

	public List<Blog> getNotApprovedList() {
		String hql = "from Blog where status = " + "'NA'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();
		
		return list;
	}

	public Blog get(int id) {
		String hql = "from Blog where id ='" + id + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) query.list();

		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		
		return null;
	}

	public Blog get_title(String title) {
		String hql = "from Blog where blogtitle ='" + title + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) query.list();

		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		return null;
	}

	public void saveOrUpdate(Blog blog) {
		// TODO Auto-generated method stub
		
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}
	
	
	
	
	

	public void delete(int id) {
		// TODO Auto-generated method stub
		Blog blogToDelete = new Blog();
		blogToDelete.setBlogId(id);
		sessionFactory.getCurrentSession().delete(blogToDelete);
		
	}

	public List<Blog> getApprovedList(int approved) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addComment(BlogCommentz blogcomment) {
		Session session =sessionFactory.openSession();
		session.save(blogcomment);
	    session.flush();
		session.close();
	}

}
