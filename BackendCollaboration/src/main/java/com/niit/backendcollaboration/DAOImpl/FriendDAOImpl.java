package com.niit.backendcollaboration.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendcollaboration.DAO.FriendDAO;
import com.niit.backendcollaboration.model.Friend;
@Transactional
@Repository
public class FriendDAOImpl implements FriendDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Friend> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Friend> friendList = sessionFactory.getCurrentSession().createQuery("from Friend").list();
		return friendList;
	}

	public Friend saveOrUpdate(Friend friend) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
		return friend;
	}

	public Friend getByFriendId(int id) {
		// TODO Auto-generated method stub
		Friend friendListByID = (Friend) sessionFactory.getCurrentSession().get(Friend.class, id);

		return friendListByID;

	}

	public List<Friend> getByFriendName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Friend where friendName =" + "'" + name + "' and status = " + "'P'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> listFriend = (List<Friend>) query.list();
		return listFriend;
	}

	public List<Friend> getByFriendAccepted(String name) {
		// TODO Auto-generated method stub
		String hql = "from Friend where friendName =" + "'" + name + "' and status = " + "'A'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> listFriend = (List<Friend>) query.list();
		return listFriend;
	}
	

	public void delete(int id) {
		// TODO Auto-generated method stub
		Friend friendToDelete = new Friend();
		friendToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(friendToDelete);
	}
	public List<Friend> list(int friendId) {
		String hql = "from Friend where userId =" + "'" + friendId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> listFriend = (List<Friend>) query.list();

		return listFriend;
	}

}
