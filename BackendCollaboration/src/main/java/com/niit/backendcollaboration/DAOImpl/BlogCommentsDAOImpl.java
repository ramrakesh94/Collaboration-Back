package com.niit.backendcollaboration.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendcollaboration.DAO.BlogCommentsDAO;
import com.niit.backendcollaboration.model.BlogCommentz;
@Transactional
@Repository
public class BlogCommentsDAOImpl implements BlogCommentsDAO {
	
	@Autowired
	
	private SessionFactory sessionFactory;

	
	public BlogCommentsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<BlogCommentz> list() {
		@SuppressWarnings({ "unchecked" })
		List<BlogCommentz> listBlogComment = (List<BlogCommentz>) sessionFactory.getCurrentSession().createCriteria(BlogCommentz.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listBlogComment;
	}

	public List<BlogCommentz> getBlogComments(int blogId) {
		String hql = "from BlogCommentz where blogId ='" + blogId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BlogCommentz> listBlogComment = (List<BlogCommentz>) query.list();
		
		return listBlogComment;
	}

	public BlogCommentz getBlogComment(int blogCommentId) {
		String hql = "from BlogCommentz where id ='" + blogCommentId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BlogCommentz> listComment = (List<BlogCommentz>) query.list();
		if (listComment != null && !listComment.isEmpty()) {
			return listComment.get(0);
		}
		return null;
	}

	public BlogCommentz saveOrUpdate(BlogCommentz bcomment) {
		sessionFactory.getCurrentSession().saveOrUpdate(bcomment);
		return bcomment;
	}

	public void delete(int id) {
		BlogCommentz commentToDelete = new BlogCommentz();
		commentToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(commentToDelete);
		
	}
	
	

}
