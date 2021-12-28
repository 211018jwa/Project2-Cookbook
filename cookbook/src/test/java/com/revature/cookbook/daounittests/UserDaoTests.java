package com.revature.cookbook.daounittests;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.annotation.Transactional;

import com.revature.cookbook.dao.UserDao;
import com.revature.cookbook.model.User;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserDaoTests {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private UserDao userDaoSut;
	
	@Test
	@Transactional
	public void getAllUsersPositive() {
		
		User user = new User();
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("test");
		
		List<User> expectedList = new ArrayList<>();
		
		expectedList.add(user);
		
		em.persist(user);
		em.flush();
		
		List<User> userList = userDaoSut.getAllUsers();
		
		Assertions.assertEquals(expectedList, userList);
		
	}
	
	@Test
	@Transactional
	public void getAllUsersNoUsersToGetNegative() {
		
		
		List<User> expectedList = new ArrayList<>();
		
		List<User> actualList = userDaoSut.getAllUsers();
		
		Assertions.assertEquals(expectedList, actualList);
		
		
	}
	
	@Test
	@Transactional
	public void deleteUserWithIdPositive() {
		
		User userToDelete = new User();
		userToDelete.setUsername("username");
		userToDelete.setPassword("password");
		userToDelete.setEmail("test");
		
		em.persist(userToDelete);
		em.flush();
		
		userDaoSut.deleteUserById(userToDelete.getId());
		
		Assertions.assertEquals(null, userDaoSut.getUserById(userToDelete.getId()));

		
	}
	
	@Test
	@Transactional
	public void deleteUserWithIdUserDoesntExistNegative() {
	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			userDaoSut.deleteUserById(9999);
			
		});
		
	}
	
	@Test
	@Transactional
	public void getUserByIdPositive() {
		
		User user = new User();
		
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("test");
		
		em.persist(user);
		em.flush();
		
		Assertions.assertEquals(user, userDaoSut.getUserById(user.getId()));
		
	}
	
	@Test
	@Transactional
	public void getUserByIdUserDoesntExistNegative() {
		
		Assertions.assertEquals(null, userDaoSut.getUserById(9999));
		
	}
	
	@Test
	@Transactional
	public void getUserByUsernamePositive() {
		
		User user = new User();
		
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("test");
		
		em.persist(user);
		em.flush();
		
		Assertions.assertEquals(user, userDaoSut.getUserByUsername("username"));
		
	}
	
	@Test
	@Transactional
	public void getUserByUsernameUserDoesntExistNegative() {
		
		Assertions.assertEquals(null, userDaoSut.getUserByUsername("username"));
		
	}
	
	@Test
	@Transactional
	public void getUserByEmailPositive() {
		
		User user = new User();
		
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("test");
		
		em.persist(user);
		em.flush();
		
		Assertions.assertEquals(user, userDaoSut.getUserByEmail("test"));
		
	}
	
	@Test
	@Transactional
	public void getUserByEmailUserDoesntExistNegative() {
		
		Assertions.assertEquals(null, userDaoSut.getUserByEmail("email"));
		
	}
	
	@Test
	@Transactional
	public void getUserByUsernameAndPasswordPositive() {
		
		User user = new User();
		
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("test");
		
		em.persist(user);
		em.flush();
		
		Assertions.assertEquals(user, userDaoSut.getUserByUsernameAndPassword("username", "password"));
		
	}
	
	@Test
	@Transactional
	public void getUserByUsernameAndPasswordNoMatchNegative() {
		
		Assertions.assertEquals(null, userDaoSut.getUserByUsernameAndPassword("username", "password"));
		
		
	}
	
}
