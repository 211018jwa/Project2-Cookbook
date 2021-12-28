package com.revature.cookbook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.cookbook.model.User;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager em;
	
	Logger logger = LoggerFactory.getLogger(UserDao.class); 
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getAllUsers(){
		Session session = em.unwrap(Session.class);
		
		List<User> users =  session.createQuery("SELECT us FROM User us").getResultList();
		
		logger.info("DAO: Getting all users");
		
		return users;
	}
	
	@Transactional
	public void deleteUserById(int id) throws IllegalArgumentException {
		Session session = em.unwrap(Session.class);
		
		User deletedUser = session.get(User.class, id);
		
		if(deletedUser == null) {
			
			logger.info("USER DAO: Cannot delete user. User with id of " + id + " does not exist");
			throw new IllegalArgumentException("Cannot delete user. User with id of " + id +" does not exist");
			
			
		}
		
		session.remove(deletedUser);
		
		logger.info("DAO: Deleted user with id " + id);
	}
	
	@Transactional
	public User getUserById(int id) {
		Session session = em.unwrap(Session.class);
		
		User user = session.get(User.class, id);
		
		logger.info("DAO: Getting user with ID of " + id);
		return user;
	
	}
	
	@Transactional
	public User addUser(User user) {
		em.persist(user);
		
		
		logger.info("DAO: successfully added user: " + user.toString());
		return user;
	}
	
	@Transactional
	public User getUserByUsername(String username) throws NonUniqueResultException {	//shouldnt ever throw this exception, because usernames should be unique. REALLY messed up if it throws
		
		//MAKE SURE WHEN YOU ARE USING THIS, THAT THE USERNAME IS ALREADY HASHED WITH SHA256, OTHERWISE IT WILL ALWAYS RETURN NULL
		
		try {
			
			User user = (User) em.createQuery("FROM User u WHERE u.username = :username").setParameter("username", username).getSingleResult();
			
			logger.info("DAO: Got user by username " + username + ": " + user.toString());
			return user; 
			
		}
		
		catch(NoResultException e) {
			
			
			logger.info("DAO: No user with username of " + username);
			return null; 
			
		}
		
	}
	
	@Transactional
	public User getUserByEmail(String email) {
		
		try {
			
			User user = (User) em.createQuery("FROM User u WHERE u.email = :email").setParameter("email", email).getSingleResult();
			logger.info("DAO: Got user by email " + email + ": " + user.toString());
			return user; 
			
		}
		catch(NoResultException e) {
			
			logger.info("DAO: No user with email of " + email);
			return null; 
			
		}
		
	}
	
	@Transactional()
	public User getUserByUsernameAndPassword(String username, String password) {
		try {
			User user = (User) em.createQuery("FROM User u WHERE u.username = :user AND u.password = :pass")
					.setParameter("user", username)
					.setParameter("pass", password)
					.getSingleResult();
			
			
			logger.info("DAO: Got user by username and password " + user.toString());
			
			return user;
		}catch(NoResultException e) {
			logger.info("DAO: No username and password combination match");
			return null;
		}
	}
	
}
