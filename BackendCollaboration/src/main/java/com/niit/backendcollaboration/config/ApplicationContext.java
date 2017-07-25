package com.niit.backendcollaboration.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backendcollaboration.DAO.AppliedJobsDAO;
import com.niit.backendcollaboration.DAO.BlogCommentsDAO;
import com.niit.backendcollaboration.DAO.BlogDAO;
/*import com.niit.backendcollaboration.DAO.ChatDAO;*/
/*import com.niit.backendcollaboration.DAO.EventsDAO;*/
/*import com.niit.backendcollaboration.DAO.ForumCommentsDAO;
import com.niit.backendcollaboration.DAO.ForumDAO;*/
import com.niit.backendcollaboration.DAO.FriendDAO;
import com.niit.backendcollaboration.DAO.JobDAO;
import com.niit.backendcollaboration.DAO.UserDAO;
import com.niit.backendcollaboration.DAOImpl.AppliedJobsDAOImpl;
import com.niit.backendcollaboration.DAOImpl.BlogCommentsDAOImpl;
import com.niit.backendcollaboration.DAOImpl.BlogDAOImpl;
/*import com.niit.backendcollaboration.DAOImpl.ForumDAOImpl;*/
import com.niit.backendcollaboration.DAOImpl.FriendDAOImpl;
import com.niit.backendcollaboration.DAOImpl.JobDAOImpl;
import com.niit.backendcollaboration.DAOImpl.UserDAOImpl;
import com.niit.backendcollaboration.model.AppliedJobs;
import com.niit.backendcollaboration.model.Blog;
import com.niit.backendcollaboration.model.BlogCommentz;
import com.niit.backendcollaboration.model.Chat;
import com.niit.backendcollaboration.model.Friend;
import com.niit.backendcollaboration.model.Job;
import com.niit.backendcollaboration.model.User;

@Configuration
@ComponentScan("com.niit.backendcollaboration")
@EnableTransactionManagement

public class ApplicationContext {
	
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
		/* logger.debug("Starting of the method getOracleDataSource"); */
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

		// dataSource.setUsername("asdfghj"); // Schema name
		dataSource.setUsername("ORACLE");
		dataSource.setPassword("oracle");

		/*
		 * logger.debug("Setting the data source :" +
		 * dataSource.getConnectionProperties());
		 */
		/* logger.debug("Ending of the method getOracleDataSource"); */
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		/* logger.debug("Starting of the method getSessionFactory"); */
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(BlogCommentz.class);
		sessionBuilder.addAnnotatedClass(Chat.class); 
		/*sessionBuilder.addAnnotatedClass(Events.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(ForumCommentz.class);*/
		sessionBuilder.addAnnotatedClass(Friend.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(AppliedJobs.class);
		

		/* logger.debug("Ending of the method getSessionFactory"); */
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		/* logger.debug("Starting of the method getTransactionManager"); */
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		/* logger.debug("Ending of the method getTransactionManager"); */
		return transactionManager;
	}

	@Autowired(required = true)
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}

	@Autowired(required = true)
	@Bean(name = "blogDAO")
	public BlogDAO getBlogDAO(SessionFactory sessionFactory) {
		return new BlogDAOImpl(sessionFactory);
	}

	/*@Autowired(required = true)
	@Bean(name = "eventsDAO")
	public EventsDAO getEventsDAO(SessionFactory sessionFactory) {
		return new EventsDAOImpl(sessionFactory);
	}*/

	/*@Autowired(required = true)
	@Bean(name = "forumDAO")
	public ForumDAO getForumDAO(SessionFactory sessionFactory) {
		return new ForumDAOImpl(sessionFactory);*/
	

	/*@Autowired(required = true)
	@Bean(name = "chatDAO")
	public ChatDAO getChatDAO(SessionFactory sessionFactory) {
		return new ChatDAOImpl(sessionFactory);
	}*/

	@Autowired(required = true)
	@Bean(name = "friendDAO")
	public FriendDAO getFriendDAO(SessionFactory sessionFactory) {
		return new FriendDAOImpl(sessionFactory);
	}

	@Autowired(required = true)
	@Bean(name = "jobDAO")
	public JobDAO getJobDAO(SessionFactory sessionFactory) {
		return new JobDAOImpl(sessionFactory);
	}
	
		/*@Autowired(required = true)
		@Bean(name = "forumCommentsDAO")
		public ForumCommentsDAOImpl getForumCommentDAO(SessionFactory sessionFactory) {
			
		return new ForumCommentsDAOImpl(sessionFactory);
		}*/
		/*@Autowired(required = true)
		@Bean(name = "blogCommentsDAO")
		public BlogCommentsDAO getBlogCommentsDAO(SessionFactory sessionFactory) {
			return new BlogCommentsDAOImpl(sessionFactory);
		}*/
	
	@Autowired(required = true)
	@Bean(name = "appliedJobsDAO")
	public AppliedJobsDAO getAjobDAO(SessionFactory sessionFactory) {
		return new AppliedJobsDAOImpl(sessionFactory);
	}

}

