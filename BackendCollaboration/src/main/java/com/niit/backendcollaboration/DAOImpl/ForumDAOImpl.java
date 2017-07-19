/*package com.niit.backendcollaboration.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendcollaboration.DAO.ForumDAO;
import com.niit.backendcollaboration.model.Forum;
@Transactional
@Repository
public class ForumDAOImpl implements ForumDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Forum> list() {
		@SuppressWarnings("unchecked")
		List<Forum> forumList = sessionFactory.getCurrentSession().createQuery("from Forum").list();
		return forumList;
	}

	public List<Forum> getAcceptedList() {
		// TODO Auto-generated method stub
		String hql = "from Forum where status = " + "'A'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();
		
		return list;
	}

	public List<Forum> getNotAcceptedList() {
		// TODO Auto-generated method stub
		String hql = "from Forum where status = " + "'NA'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();
		
		return list;
	}

	public Forum get(int forumId) {
		String hql = "from Forum where forumId ='" + forumId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> listForum = (List<Forum>) query.list();

		if (listForum != null && !listForum.isEmpty()) {
			return listForum.get(0);
		}
		return null;
	}

	public Forum saveOrUpdate(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return forum;
	}

	public void delete(int forumId) {
		// TODO Auto-generated method stub
		Forum forumToDelete = new Forum();
		forumToDelete.setForumId(forumId);
		sessionFactory.getCurrentSession().delete(forumToDelete);
	}

}
*/