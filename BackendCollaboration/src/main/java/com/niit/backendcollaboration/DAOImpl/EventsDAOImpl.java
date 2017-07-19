/*package com.niit.backendcollaboration.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendcollaboration.DAO.EventsDAO;
import com.niit.backendcollaboration.model.Events;
@Transactional
@Repository
public class EventsDAOImpl implements EventsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public EventsDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public List<Events> list() {
		return sessionFactory.getCurrentSession().createQuery("from Event").list();
		
	}

	public void saveOrUpdate(Events event) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		
	}

	public Events getEventId(int id) {
		Events eventListByID = (Events) sessionFactory.getCurrentSession().get(Events.class, id);
		return eventListByID;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(id);
		
	}

}
*/