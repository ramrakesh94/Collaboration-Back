package com.niit.backendcollaboration.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendcollaboration.DAO.ChatDAO;
import com.niit.backendcollaboration.model.Chat;
@Transactional
@Repository("ChatDAO")
public class ChatDAOImpl implements ChatDAO {
     
	@Autowired
	private SessionFactory sessionFactory;
	
	public ChatDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Chat> list() {
		@SuppressWarnings("unchecked")
		List<Chat> chatList = sessionFactory.getCurrentSession().createQuery("from Chat").list();
		return chatList;
	}

	public void saveOrUpdate(Chat chat) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(chat);
	}

	public Chat getByFriendId(int id) {
		// TODO Auto-generated method stub
		Chat chatListByID = (Chat) sessionFactory.getCurrentSession().get(Chat.class, id);

		return chatListByID;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(id);
	}

}
