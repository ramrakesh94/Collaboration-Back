package com.niit.backendcollaboration.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendcollaboration.model.BlogCommentz;
import com.niit.backendcollaboration.model.ForumCommentz;
@Transactional
@Repository
public class ForumCommentsDAOImpl {
	
	
@Autowired
	
	private SessionFactory sessionFactory;

	
	public ForumCommentsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<ForumCommentz> list() {
		@SuppressWarnings({ "unchecked" })
		List<ForumCommentz> listforumComment = (List<ForumCommentz>) sessionFactory.getCurrentSession().createCriteria(BlogCommentz.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listforumComment;
	}

	public List<ForumCommentz> getForumComments(int forumId) {
		String hql = "from ForumCommentz where forumId ='" + forumId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<ForumCommentz> listforumComment = (List<ForumCommentz>) query.list();
		
		return listforumComment;
	}

	public ForumCommentz getForumComment(int forumId) {
		String hql = "from ForumCommentz where id ='" + forumId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<ForumCommentz> listComment = (List<ForumCommentz>) query.list();
		if (listComment != null && !listComment.isEmpty()) {
			return listComment.get(0);
		}
		return null;
	}

	public ForumCommentz saveOrUpdate(ForumCommentz fcomment) {
		sessionFactory.getCurrentSession().saveOrUpdate(fcomment);
		return fcomment;
	}

	public void delete(int id) {
		BlogCommentz commentToDelete = new BlogCommentz();
		commentToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(commentToDelete);
		
	}
	
	

}
