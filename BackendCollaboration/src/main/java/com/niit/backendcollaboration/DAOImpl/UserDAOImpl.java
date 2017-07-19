package com.niit.backendcollaboration.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendcollaboration.DAO.UserDAO;
import com.niit.backendcollaboration.model.User;
@Transactional
@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<User> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	public User getById(int id) {
		// TODO Auto-generated method stub
		User userById = (User) sessionFactory.getCurrentSession().get(User.class, id);

		return userById;
	}

	public User getByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from User where username =" + "'" + name + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		String hql = "from User where email =" + "'" + email + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listEmail = (List<User>) query.list();

		if (listEmail != null && !listEmail.isEmpty()) {
			return listEmail.get(0);
		}
		return null;
		
		
		/*User userByEmail = (User) sessionFactory.getCurrentSession().get(User.class, email);

		return userByEmail;*/
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

		User userToDelete = new User();
		userToDelete.setCusId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	public User login(User user) {
		// TODO Auto-generated method stub

		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		String hql = "from User where email=" + "'" + user.getEmail() + "'and password = " + "'" + user.getPassword() + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);

		}
		return null;
	}

	public List<String> getOnlineUsers() {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("select username from User where online=1");
		List<String> onlineUsers=query.list();
		session.close();
		return onlineUsers;
		}
	}


